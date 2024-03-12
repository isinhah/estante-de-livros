import controller.BookController;
import model.Book;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/livrariajdbc?user=root&password=admin")) {
            BookController controller = new BookController(conn);
            Scanner scanner = new Scanner(System.in);
            int opcao = 0;

            while (opcao != 5) {
                System.out.println("\n====== MENU ======");
                System.out.println("1. Listar livros");
                System.out.println("2. Adicionar livro");
                System.out.println("3. Atualizar livro");
                System.out.println("4. Excluir livro");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        controller.read();
                        break;
                    case 2:
                        addBook(scanner, controller);
                        break;
                    case 3:
                        updateBook(scanner, controller);
                        break;
                    case 4:
                        deleteBook(scanner, controller);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBook(Scanner scanner, BookController controller) {
        System.out.println("====== Adicionar Livro ======");
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Gênero: ");
        String genre = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Número de Páginas: ");
        int quantityPages = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Book book = new Book();
        book.setName(name);
        book.setGenre(genre);
        book.setAuthor(author);
        book.setQuantityPages(quantityPages);

        controller.create(book);
    }

    public static void updateBook(Scanner scanner, BookController controller) {
        System.out.println("====== Atualizar Livro ======");
        System.out.print("ID do Livro: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Novo Nome: ");
        String name = scanner.nextLine();
        System.out.print("Novo Gênero: ");
        String genre = scanner.nextLine();
        System.out.print("Novo Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Novo Número de Páginas: ");
        int numeroPaginas = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Book book = new Book();
        book.setName(name);
        book.setGenre(genre);
        book.setAuthor(autor);
        book.setQuantityPages(numeroPaginas);

        controller.update(id, book);
    }

    public static void deleteBook(Scanner scanner, BookController controller) {
        System.out.println("====== Excluir Livro ======");
        System.out.print("ID do Livro: ");
        int id = scanner.nextInt();
        controller.delete(id);
    }
}