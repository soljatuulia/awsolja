package net.virkkunen.bookjdbc;


import net.virkkunen.bookjdbc.Author;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Solja
 */
public class AuthorDAO {

    private Connection getConnection() throws SQLException {
        try {    
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","librarian","test123");
            return con;
       
        } catch (SQLException ex) {    
            ex.printStackTrace();
        } return null;
    }

    private Author authorFromResultSet(ResultSet rs) throws SQLException {
        try {
        Author a = new Author();
        a.setId(rs.getInt("id"));
        a.setFirstName(rs.getString("firstname"));
        a.setLastName(rs.getString("lastname"));
        a.setBirthDate(rs.getDate("birthdate"));
        a.setDeathDate(rs.getDate("deathdate"));
        return a;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Author get(int id) {
    // Uses the first two to return author that has been fetched from the database
        try {
            String sql = "SELECT * from author where id=?";
            Connection con = getConnection();
            if (con == null) return null;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            //Statement stm = con.createStatement(); // tämän tilalle preparedStatement
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Author a = authorFromResultSet(rs); // muodostuu Author-objektiksi
                stm.close();
                rs.close();
                con.close(); //mieti, missä vaiheessa sulkemiset, jotta tulee aina tehtyä!
                return a;                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    // voi käyttää tavallista statementia (ei Prepared), koska ei tule parametriä
    public List<Author> getAll() {
        ArrayList<Author> authors = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * from author ORDER BY lastname,firstname");
            while (rs.next()) {
                authors.add(authorFromResultSet(rs));
            }
                stm.close();
                rs.close();
                con.close(); //mieti, missä vaiheessa sulkemiset, jotta tulee aina tehtyä!
                // return authors;                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return authors;        
    }
    
    public Author create(Author a) {
        // use prepared statement
        // vaatii Authoriin konstruktorin, jotta objekti voidaan luoda mainissa
        try{
            Connection con=getConnection();
            String sql="INSERT INTO Author(firstname,lastname,birthdate,deathdate) values(?,?,?,?)";
            PreparedStatement stm=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, a.getFirstName());
            stm.setString(2, a.getLastName());
            stm.setDate(3, a.getBirthDate());
            stm.setDate(4, a.getDeathDate());
            int rowsAffected=stm.executeUpdate(); //???
            ResultSet keys=stm.getGeneratedKeys();
            if (keys.next()) {
                int id=keys.getInt(1);
                stm.close();
                keys.close();
                con.close();
                return this.get(id);
            }
            
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;    
    }
    
    public Author update(Author a) {
        // use updatable resultset -- muokataan resultsettiä siten, että sinne menee annetun 
        // authorin data
        // palauta sellaisena kuin se tallentui tietokantaan
        // primary key!
        // kopio createsta. mikä kyssäri id:n tilalla --> vaihtuu.
        // vie arvot objektilta niitä vastaaviin sarakkeisiin (annettu parametreina)
        try {
            Connection con = getConnection();
            String sql = "UPDATE author (firstname,lastname,birthdate,deathdate) VALUES (?,?,?,?)"; // voivat olla missä tahansa järjestyksessä
            PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            // tietokanta generoi id:n, me saamme sen palautuksen omaisesti
            stm.setString(1, a.getFirstName());
            stm.setString(2, a.getLastName());
            stm.setDate(3, a.getBirthDate());
            stm.setDate(4, a.getDeathDate());
            int rowsAffected = stm.executeUpdate(); // kuinka moneen riviin vaikutti
            ResultSet keys = stm.getGeneratedKeys();     
            if (keys.next()) {
                int id = keys.getInt(1); //juuri luodun authorin Primary key -arvo
                stm.close();
                keys.close();
                con.close();
                return this.get(id); //haetaan tietokannasta se, joka sinne juuri lisättiin
            }
                
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        
        return null;
    }
    
    public boolean delete(int id) {
        return false;
    }
    
    public Author getAuthorOfBook(int book) {
        try {
            String sql = "Select a.* from book b, author a where a.id=b.author_id AND b.id=?";
            // oma vaikeampi versio: Select * from author a left join book b on (b.author_id=a.id) where b.id=?
            Connection con = getConnection();
            if (con == null) return null;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, book);
            ResultSet rs = stm.executeQuery();
            Author a = null;
            if (rs.next()) {
                a = authorFromResultSet(rs); // muodostuu Author-objektiksi
                return a;                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Book> getBooksOfAuthor(int authorid){
        return new BookDAO().getBooksOfAuthor(authorid);
    }
    
    public void getBooks(Author author) {
        // reads the book from the author and places them to books field of author object
        author.setBooks(getBooksOfAuthor(author.getId()));
    }

}
