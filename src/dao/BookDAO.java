package dao;

import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection conn;

    public BookDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Book> listBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM livros";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setGenre(rs.getString("genre"));
                book.setAuthor(rs.getString("author"));
                book.setQuantityPages(rs.getInt("quantityPages"));

                books.add(book);
            }
        }

        System.out.println("\nLivros armazenados: " + books.size());
        return books;
    }

    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO livros (name, genre, author, quantityPages) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getName());
            ps.setString(2, book.getGenre());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getQuantityPages());

            ps.executeUpdate();
        }
    }

    public void updateBook(int id, Book updatedBook) throws SQLException {
        String sql = "UPDATE livros SET name = ?, genre = ?, author = ?, quantityPages = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, updatedBook.getName());
            ps.setString(2, updatedBook.getGenre());
            ps.setString(3, updatedBook.getAuthor());
            ps.setInt(4, updatedBook.getQuantityPages());
            ps.setInt(5, id);

            ps.executeUpdate();
        }
    }

    public void deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM livros WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
