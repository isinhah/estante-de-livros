package controller;

import dao.BookDAO;
import model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookController {
    private BookDAO bookDAO;

    public BookController(Connection conn) {
        this.bookDAO = new BookDAO(conn);
    }

    public void read() {
        try {
            List<Book> books = bookDAO.listBooks();
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao mostrar os livros: " + e.getMessage());
        }
    }

    public void create(Book book) {
        try {
            bookDAO.addBook(book);
            System.out.println("Livro adicionado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar o livro: " + e.getMessage());
        }
    }

    public void update(int id, Book book) {
        try {
            bookDAO.updateBook(id, book);
            System.out.println("Livro atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o livro: " + e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            bookDAO.deleteBook(id);
            System.out.println("Livro excluído com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir o livro: " + e.getMessage());
        }
    }
}