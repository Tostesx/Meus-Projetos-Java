package br.uemg.pacote;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class PainelJogo extends JPanel implements ActionListener {

	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 60;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int partesCorpo = 6;
	int macaComida;
	int macaX;
	int macaY;
	char direcao = 'R';
	boolean rodando = false;
	Timer timer;
	Random random;

	PainelJogo() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		comecoJogo();

	}

	public void comecoJogo() {
		novaMaca();
		rodando = true;
		timer = new Timer(DELAY, this);
		timer.start();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		desenho(g);
	}

	public void desenho(Graphics g) {
		if (rodando) {
			for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
				g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
			}
			
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			g.fillOval(macaX, macaY, UNIT_SIZE, UNIT_SIZE);

			for (int i = 0; i < partesCorpo; i++) {
				if (i == 0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				} else {
					g.setColor(new Color(45, 180, 0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free", Font.BOLD, 20));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Pontos: " + macaComida, (SCREEN_WIDTH - metrics.stringWidth("Pontos: " + macaComida)) / 2,
					g.getFont().getSize());

		} else {
			gameOver(g);
		}
	}

	public void novaMaca() {
		macaX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		macaY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

	}

	public void mover() {
		for (int i = partesCorpo; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];

		}
		switch (direcao) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
	}

	public void checarMaca() {
		if ((x[0] == macaX) && (y[0] == macaY)) {
			partesCorpo++;
			macaComida++;
			novaMaca();
		}

	}

	public void checarColisao() {
		// Checa se a cabeça colide com o corpo
		for (int i = partesCorpo; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				rodando = false;
			}
		}
		// Checa se a cabeça colide com a borda esquereda
		if (x[0] < 0) {
			rodando = false;
		}
		// Checa se a cabeça colide com a borda direita
		if (x[0] > SCREEN_WIDTH) {
			rodando = false;
		}
		// Checa se a cabeça colide com topo
		if (y[0] < 0) {
			rodando = false;
		}
		// Checa se a cabeça colide com o fundo
		if (y[0] > SCREEN_HEIGHT) {
			rodando = false;
		}
		if (!rodando) {
			timer.stop();
		}
	}

	public void gameOver(Graphics g) {
		// Pontuação final
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 50));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Pontuação Final: " + macaComida,
				(SCREEN_WIDTH - metrics1.stringWidth("Pontuação Final: " + macaComida)) / 2, g.getFont().getSize());
		// Texto de fim de jogo
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Fim de Jogo", (SCREEN_WIDTH - metrics2.stringWidth("Fim de Jogo")) / 2, SCREEN_HEIGHT / 2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (rodando) {
			mover();
			checarMaca();
			checarColisao();

		}
		repaint();
	}

	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if (direcao != 'R') {
					direcao = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (direcao != 'L') {
					direcao = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if (direcao != 'D') {
					direcao = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if (direcao != 'U') {
					direcao = 'D';
				}
				break;
			}
		}
	}
}