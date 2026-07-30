import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * PROJETO: SwiftScore
 * OBJETIVO TÉCNICO:
 * - Leitura de dados e controle de fluxo via Menu (Scanner/Switch-Case).
 * - Armazenamento e manipulação de objetos em memória (ArrayList).
 * - Ordenação dinâmica usando Lambdas e Method References (Comparator).
 */
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        List<Musica> listaDeMusicas = new ArrayList<>();
        carregarAlbumTheLifeOfAShowgirl(listaDeMusicas);

        boolean executando = true;

        while (executando) {
            System.out.println("\n==========================================");
            System.out.println("   BEM-VINDO AO SWIFTSCORE - Album: The Life of a Showgirl");
            System.out.println("==========================================");
            System.out.println("1. Avaliar uma música");
            System.out.println("2. Exibir Ranking Atual");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcaoMenu = scanner.nextInt();

            switch (opcaoMenu) {
                case 1:
                    avaliarMusica(scanner, listaDeMusicas);
                    break;

                case 2:
                    exibirRanking(listaDeMusicas);
                    break;

                case 0:
                    System.out.println("\nEncerando a sessão... Veja abaixo o resultado final!");
                    exibirRanking(listaDeMusicas);
                    executando = false;
                    break;

                default:
                    System.out.println("⚠️ Opção inválida! Escolha 1, 2 ou 0.");
            }
        }

        scanner.close();
    }

    /**
     * Lógica para avaliar uma faixa
     */
    private static void avaliarMusica(Scanner scanner, List<Musica> lista) {
        System.out.println("\n--- FAIXAS DISPONÍVEIS PARA AVALIAÇÃO ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).getTitulo());
        }

        System.out.print("\nDigite o número da música que deseja avaliar: ");
        int opcao = scanner.nextInt();

        if (opcao >= 1 && opcao <= lista.size()) {
            Musica musicaSelecionada = lista.get(opcao - 1);

            System.out.print("Qual nota (0 a 10) você dá para '" + musicaSelecionada.getTitulo() + "'? ");
            double nota = scanner.nextDouble();

            musicaSelecionada.avaliar(nota);
            musicaSelecionada.reproduzir();

            System.out.println("✅ Avaliação registrada para '" + musicaSelecionada.getTitulo() + "'!");
        } else {
            System.out.println("⚠️ Opção de música inválida!");
        }
    }

    /**
     * Lógica para ordenar e exibir o Ranking Atual
     */
    private static void exibirRanking(List<Musica> lista) {
        // Ordena a lista da maior média para a menor
        lista.sort(Comparator.comparingDouble(Musica::pegarMedia).reversed());

        System.out.println("\n==========================================");
        System.out.println("         🏆 RANKING ATUAL DO ÁLBUM        ");
        System.out.println("==========================================");

        int posicao = 1;
        for (Musica m : lista) {
            if (m.getQuantidadeAvaliacoes() > 0) {
                System.out.printf("%dº Lugar: %-50s | Média: %.2f (%d avaliações)\n",
                        posicao, m.getTitulo(), m.pegarMedia(), m.getQuantidadeAvaliacoes());
                posicao++;
            }
        }

        if (posicao == 1) {
            System.out.println("ℹ️ Nenhuma música foi avaliada até o momento.");
        }
        System.out.println("==========================================");
    }

    /**
     * Método auxiliar para carregar o álbum
     */
    private static void carregarAlbumTheLifeOfAShowgirl(List<Musica> lista) {
        String[] faixas = {
                "The Fate of Ophelia",
                "Elizabeth Taylor",
                "Opalite",
                "Father Figure",
                "Eldest Daughter",
                "Ruin the Friendship",
                "Actually Romantic",
                "Wish List",
                "Wood",
                "Cancelled",
                "Honey",
                "The Life of a Showgirl (part. Sabrina Carpenter)"
        };

        for (String titulo : faixas) {
            Musica m = new Musica();
            m.setTitulo(titulo);
            m.setArtista("Taylor Swift");
            m.setAlbum("The Life of a Showgirl");
            lista.add(m);
        }
    }
}