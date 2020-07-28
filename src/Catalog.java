import java.io.*;
import java.util.ArrayList;
/**
 * @author Jacob Sandefur
 * @version 3/31/2020
 */

public class Catalog {
    private ArrayList<Book> catalog;

    public static void main(String[] args) throws IOException, UnsupportedFileException {
        Catalog catalog = new Catalog();
        File file1 = new File("bookList.txt");
        catalog.loadCatalog(file1);

        File file2 = new File("check.txt");
        catalog.writeCatalog(file2);

        File file3 = new File("check2.txt");
        catalog.printCatalogToFile(3, file3);
    }

    public Catalog() {
        catalog = new ArrayList<Book>();
    }


    public void loadCatalog(File bookCatalog) throws FileNotFoundException, UnsupportedFileException, IOException{
        if (bookCatalog.exists()) {
            FileReader fr = new FileReader(bookCatalog);
            BufferedReader bfr = new BufferedReader(fr);

            String line = bfr.readLine();
            while (line != null) {
                String[] att = line.split(", ");
                if (att.length != 10) {
                    throw new UnsupportedFileException("Missing Fields");
                }
                double purchasePrice = 0.0;
                int numCheckouts = 0;
                int id = 0;
                int pubYear = 0;

                purchasePrice = Double.parseDouble(att[8]);
                numCheckouts = Integer.parseInt(att[7]);
                id = Integer.parseInt(att[0]);
                pubYear = Integer.parseInt(att[6]);


                boolean loaned = true;
                if (!att[9].equalsIgnoreCase("yes")) {
                    loaned = false;
                }
                Book b = new Book(id, att[1], att[2], att[3], att[4], att[5], pubYear, numCheckouts,
                        purchasePrice, loaned);
                this.catalog.add(b);

                line = bfr.readLine();
            }
            
            bfr.close();

            fr.close();
            
        }
        
        else {
            throw new FileNotFoundException();
        }

    }

    public void writeCatalog(File bookCatalog) throws IOException{
        bookCatalog.createNewFile();
        //write to file

        FileOutputStream fos = new FileOutputStream(bookCatalog);
        PrintWriter pw = new PrintWriter(fos);

        for (int i = 0; i < this.catalog.size(); i++) {
            Book crntBook = catalog.get(i);
            StringBuilder sb = new StringBuilder();

            sb.append(crntBook.getId());
            sb.append(", ");
            sb.append(crntBook.getTitle());
            sb.append(", ");
            sb.append(crntBook.getAuthorFirstName());
            sb.append(", ");
            sb.append(crntBook.getAuthorLastName());
            sb.append(", ");
            sb.append(crntBook.getPublisher());
            sb.append(", ");
            sb.append(crntBook.getPublisherCity());
            sb.append(", ");
            sb.append(crntBook.getPublicationYear());
            sb.append(", ");
            sb.append(crntBook.getNumCheckouts());
            sb.append(", ");
            String purchasePrice = String.format("%.2f", crntBook.getPurchasePrice());
            sb.append(purchasePrice);
            sb.append(", ");

            if (crntBook.isCurrentlyLoaned()) {
                sb.append("Yes");
            } 
            if (!crntBook.isCurrentlyLoaned()) {
                sb.append("No");
            }
            else {
                sb.append("No");
            }

            pw.println(sb.toString());
        }
        
        fos.close();

        pw.close();
    }

    public void addBook(Book book) {
        catalog.add(book);

    }

    public boolean removeBook(int id) {
        if (id > 0 && catalog.size() > 0) {
            for (int i = 0; i < catalog.size(); i++) {
                if (catalog.get(i).getId() == id) {
                    catalog.remove(i);
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean loanBook(int id) {
        boolean found = false;
        if (id > 0 && catalog.size() > 0) {
            for (Book book : catalog) {
                if (book.getId() == id) {
                    if (book.isCurrentlyLoaned()) {
                        return false;
                    } else {
                        book.editNumLoans();
                        book.setCurrentlyLoaned(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Book> findBooks(String search) {
        ArrayList<Book> books = new ArrayList<Book>();
        for (Book b : catalog) {
            if (b.getTitle().toLowerCase().contains(search.toLowerCase())
                    || b.getAuthorFirstName().toLowerCase().contains(search.toLowerCase())

                    || b.getAuthorLastName().toLowerCase().contains(search.toLowerCase())

                    || b.getPublisher().toLowerCase().contains(search.toLowerCase())

                    || b.getPublisherCity().toLowerCase().contains(search.toLowerCase())) {

                books.add(b);
            }
        }
        return books;

    }

    public ArrayList<Book> bookSale() {
        ArrayList<Book> soldBooks = new ArrayList<Book>();
        for (Book book : catalog) {
            if (book.getNumCheckouts() < 10 && !book.isCurrentlyLoaned()) {
                soldBooks.add(book);
            }
        }
        return soldBooks;
    }

    public double avgCostPerLoan() {
        double cost = 0.0;
        for (Book book : catalog) {
            cost = cost + book.averageLoanCost();
        }

        return cost / (double)catalog.size();

    }

    public void printCatalogToFile(int mode, File newFile) throws IOException, IndexOutOfBoundsException{
        
        if (mode < 1 || mode > 3) { 
            throw new IndexOutOfBoundsException("Pick a value between 1-3");
        }

        newFile.createNewFile();

        FileOutputStream fos = new FileOutputStream(newFile);
        PrintWriter pw = new PrintWriter(fos);

        for (int i = 0; i < this.catalog.size(); i++) {
            StringBuilder sb = new StringBuilder();
            Book crntBook = catalog.get(i);

            if (mode == 1) {
                sb.append("MLA: ");
                sb.append(crntBook.getAuthorLastName());
                sb.append(", ");
                sb.append(crntBook.getAuthorFirstName());
                sb.append(". ");
                sb.append(crntBook.getTitle());
                sb.append(". ");
                sb.append(crntBook.getPublisher());
                sb.append(", ");
                sb.append(crntBook.getPublicationYear());
                sb.append(".");
            } 
            else if (mode == 2) {
                sb.append("APA: ");
                sb.append(crntBook.getAuthorLastName());
                sb.append(", ");
                sb.append(crntBook.getAuthorFirstName().charAt(0));
                sb.append(". (");
                sb.append(crntBook.getPublicationYear());
                sb.append("). ");
                sb.append(crntBook.getTitle());
                sb.append(". ");
                sb.append(crntBook.getPublisherCity());
                sb.append(": ");
                sb.append(crntBook.getPublisher());
                sb.append(".");
            } 
            else if (mode == 3) {
                sb.append("CS: ");
                sb.append(crntBook.getAuthorLastName());
                sb.append(", ");
                sb.append(crntBook.getAuthorFirstName());
                sb.append(". ");
                sb.append(crntBook.getTitle());
                sb.append(". Number of Checkouts: ");
                sb.append(crntBook.getNumCheckouts());
                sb.append(". Currently Checked Out: ");

                if (crntBook.isCurrentlyLoaned()) {
                    sb.append("Yes");
                } 
                else {
                    sb.append("No");
                }

                sb.append(".");
            }
            pw.println(sb.toString());
        }
        
        fos.close();

        pw.close();
        
    }

    public int numBooksLoaned() {
        int num = 0;
        for (Book book : catalog) {
            if (book.isCurrentlyLoaned()) {
                num++;
            }
        }
        return num;
    }

    public ArrayList<Book> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Book> catalog) {
        this.catalog = catalog;
    }
}
