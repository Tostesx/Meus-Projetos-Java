package com.github.tostesx;

import java.util.Random;
import java.util.Scanner;

public class SysTurnRPG {

	static int ataqueUsuario() {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Escolha seu ataque:");
		System.out.println("(1) - Cutilada");
		System.out.println("(2) - Especial: Tiro de Garucha");
		System.out.println("(3) - Poção de vida");
		return leitor.nextInt();
	}

	static int ataqueDoComputador() {
		Random gerador = new Random();
		return gerador.nextInt(3) + 1;
	}

	static boolean ganharPocaoComChance() {
		return Math.random() < 0.3;
	}

	static boolean ganharMunicaoChance() {
		return Math.random() < 0.2;
	}

	static void imprimeHP(int hpPlayer, int hpComputador, int contagemEspecial, int specialInimigo, int pocaoHPQuanti) {
		System.out.println("==================");
		System.out.println("- *Seu HP: " + hpPlayer);
		System.out.println("- *Munição da pistola: " + contagemEspecial);
		System.out.println("- *Suas poções: " + pocaoHPQuanti);
		System.out.println("==================");
		System.out.println("- HP do Inimigo: " + hpComputador);
		System.out.println("- Munição do inimigo: " + specialInimigo);
		System.out.println("==================");
	}

	static void batalha() {
		int hpPlayer = 150;
		int hpComputador;
		int contagemEspecial = 5;
		int specialInimigo = 3;
		int escolhaAtaque;
		int i = 1;
		int pocaoHP = 30;
		int pocaoHPQuanti = 3;

		while (hpPlayer > 0) {
			hpComputador = 10 + i;

			System.out.println("=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("INIMIGO" + i);
			System.out.println("=-=-=-=-=-=-=-=-=-=-=\n");

			while (hpPlayer > 0 && hpComputador > 0) {
				imprimeHP(hpPlayer, hpComputador, contagemEspecial, specialInimigo, pocaoHPQuanti);
				escolhaAtaque = ataqueUsuario();
				switch (escolhaAtaque) {
				case 1:
					System.out.println("Você deu uma Cutilada.");
					hpComputador -= 7 + (int) (i / 10);
					break;
				case 2:
					if (contagemEspecial > 0) {
						System.out.println("Você deu um tiro de Garrucha.");
						hpComputador -= 20 + (int) (i / 10);
						contagemEspecial--;
					} else {
						System.out.println("Está sem munição");
					}

					break;
				case 3:
					if (pocaoHPQuanti > 0 && hpPlayer < 150) {
						System.out.println("Você usou uma poção de vida. ");
						hpPlayer += pocaoHP;
						pocaoHPQuanti--;
					} else {
						System.out.println("Não pode usar poção");
					}
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
				if (hpComputador > 0) {
					escolhaAtaque = ataqueDoComputador();
					switch (escolhaAtaque) {
					case 1:
						System.out.println("Inimigo te deu uma Cutilada.");
						hpPlayer -= 3 + (int) (i / 10);
						break;
					case 2:
						System.out.println("Inimigo te deu um Chute.");
						hpPlayer -= 2 + (int) (i / 10);
						break;
					case 3:
						if (specialInimigo > 0) {
							System.out.println("Inimigo te deu um tiro de Garrucha.");
							hpPlayer -= 7 + (int) (i / 20);
							specialInimigo--;
						} else {
							System.out.println("Inimigo tentou te dar um tiro mas está sem munição");
						}
						break;
					}
				} else {
					System.out.println("O Inimigo foi derrotado!\n");
					if (ganharPocaoComChance()) {
						System.out.println("Você encontrou uma poção de vida!");
						pocaoHPQuanti++;
					}
					if (ganharMunicaoChance()) {
						System.out.println("Você conseguiu mais munição!\n");
						contagemEspecial++;
					}
				}
			}

			i++;
			specialInimigo = 3;

			if (hpPlayer > 0) {
				hpPlayer += (i / 10);
			} else {
				System.out.println("Você morreu!");
				break;
			}
		}

	}

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int continua = 1;

		while (continua == 1) {
			batalha();

			System.out.println("Fim do jogo. Deseja continuar (1)Sim e (2)Não");
			continua = leitor.nextInt();
		}
	}

}
