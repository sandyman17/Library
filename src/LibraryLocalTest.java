import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import java.util.*;
import java.io.*;

import static junit.framework.TestCase.*;
import static org.junit.Assert.fail;

public class LibraryLocalTest {
    private final InputStream originalInput = System.in;

    private final PrintStream originalOutput = System.out;

    @SuppressWarnings("FieldCanBeLocal")
    private ByteArrayInputStream testIn;

    private ByteArrayOutputStream testOut;

    @Before
    public void outputStart() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    // Begin Book Tests

    @Test(timeout = 1000)
    public void testBookFields() {
        Field id;
        Field title;
        Field authorFirstName;
        Field authorLastName;
        Field publisher;
        Field publisherCity;
        Field publicationYear;
        Field numCheckouts;
        Field purchasePrice;
        Field currentlyLoaned;


        // id test
        try {
            id = Book.class.getDeclaredField("id");

            if (!id.getType().equals(int.class)) {
                fail("Ensure that you have a field called id in class Book that is of type int!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called id in class Book!");
            return;
        }

        assertEquals("Ensure that your field id in class Book is private!",
                Modifier.PRIVATE, id.getModifiers());

        // title test
        try {
            title = Book.class.getDeclaredField("title");

            if (!title.getType().equals(String.class)) {
                fail("Ensure that you have a field called title in class Book that is of type String!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called title in class Book!");
            return;
        }

        assertEquals("Ensure that your field title in class Book is private!",
                Modifier.PRIVATE, title.getModifiers());

        // authorFirstName test
        try {
            authorFirstName = Book.class.getDeclaredField("authorFirstName");

            if (!authorFirstName.getType().equals(String.class)) {
                fail("Ensure that you have a field called authorFirstName in class Book that is of type String!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called authorFirstName in class Book!");
            return;
        }

        assertEquals("Ensure that your field authorFirstName in class Book is private!",
                Modifier.PRIVATE, authorFirstName.getModifiers());

        // authorLastName test
        try {
            authorLastName = Book.class.getDeclaredField("authorLastName");

            if (!authorLastName.getType().equals(String.class)) {
                fail("Ensure that you have a field called authorLastName in class Book that is of type String!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called authorLastName in class Book!");
            return;
        }

        assertEquals("Ensure that your field authorLastName in class Book is private!",
                Modifier.PRIVATE, authorLastName.getModifiers());

        // publisher test
        try {
            publisher = Book.class.getDeclaredField("publisher");

            if (!publisher.getType().equals(String.class)) {
                fail("Ensure that you have a field called publisher in class Book that is of type String!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called publisher in class Book!");
            return;
        }

        assertEquals("Ensure that your field publisher in class Book is private!",
                Modifier.PRIVATE, publisher.getModifiers());

        // publisherCity test
        try {
            publisherCity = Book.class.getDeclaredField("publisherCity");

            if (!publisherCity.getType().equals(String.class)) {
                fail("Ensure that you have a field called publisherCity in class Book that is of type String!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called publisherCity in class Book!");
            return;
        }

        assertEquals("Ensure that your field publisherCity in class Book is private!",
                Modifier.PRIVATE, publisherCity.getModifiers());

        // publicationYear test
        try {
            publicationYear = Book.class.getDeclaredField("publicationYear");

            if (!publicationYear.getType().equals(int.class)) {
                fail("Ensure that you have a field called publicationYear in class Book that is of type int!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called publicationYear in class Book!");
            return;
        }

        assertEquals("Ensure that your field publicationYear in class Book is private!",
                Modifier.PRIVATE, publicationYear.getModifiers());

        // numCheckouts test
        try {
            numCheckouts = Book.class.getDeclaredField("numCheckouts");

            if (!numCheckouts.getType().equals(int.class)) {
                fail("Ensure that you have a field called numCheckouts in class Book that is of type int!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called numCheckouts in class Book!");
            return;
        }

        assertEquals("Ensure that your field numCheckouts in class Book is private!",
                Modifier.PRIVATE, numCheckouts.getModifiers());

        // purchasePrice test
        try {
            purchasePrice = Book.class.getDeclaredField("purchasePrice");

            if (!purchasePrice.getType().equals(double.class)) {
                fail("Ensure that you have a field called purchasePrice in class Book that is of type double!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called purchasePrice in class Book!");
            return;
        }

        assertEquals("Ensure that your field purchasePrice in class Book is private!",
                Modifier.PRIVATE, purchasePrice.getModifiers());

        // currentlyLoaned test
        try {
            currentlyLoaned = Book.class.getDeclaredField("currentlyLoaned");

            if (!currentlyLoaned.getType().equals(boolean.class)) {
                fail("Ensure that you have a field called currentlyLoaned in class Book that is of type boolean!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called currentlyLoaned in class Book!");
            return;
        }

        assertEquals("Ensure that your field currentlyLoaned in class Book is private!",
                Modifier.PRIVATE, currentlyLoaned.getModifiers());

    }

    @Test(timeout = 1000)
    public void testBookGetters() {
        Method bookMethod;
        String currentMethod;

        currentMethod = "getId";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod);
            if (!bookMethod.getReturnType().equals(int.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns int!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));


        currentMethod = "getTitle";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod);
            if (!bookMethod.getReturnType().equals(String.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns String!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));


        currentMethod = "getAuthorFirstName";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod);
            if (!bookMethod.getReturnType().equals(String.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns String!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));

        currentMethod = "getAuthorLastName";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod);
            if (!bookMethod.getReturnType().equals(String.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns String!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));

        currentMethod = "getPublisher";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod);
            if (!bookMethod.getReturnType().equals(String.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns String!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));


        currentMethod = "getPublisherCity";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod);
            if (!bookMethod.getReturnType().equals(String.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns String!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));


        currentMethod = "getPublicationYear";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod);
            if (!bookMethod.getReturnType().equals(int.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns int!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));

        currentMethod = "getNumCheckouts";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod);
            if (!bookMethod.getReturnType().equals(int.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns int!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));


        currentMethod = "getPurchasePrice";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod);
            if (!bookMethod.getReturnType().equals(double.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns double!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));

        currentMethod = "isCurrentlyLoaned";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod);
            if (!bookMethod.getReturnType().equals(boolean.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns boolean!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));

    }

    @Test(timeout = 1000)
    public void testBookSetters() {
        Method bookMethod;
        String currentMethod;

        currentMethod = "setId";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod, int.class);
            if (!bookMethod.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns void and takes a int parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));


        currentMethod = "setTitle";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod, String.class);
            if (!bookMethod.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns void and takes a String parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));


        currentMethod = "setAuthorFirstName";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod, String.class);
            if (!bookMethod.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns void and takes a String parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));

        currentMethod = "setAuthorLastName";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod, String.class);
            if (!bookMethod.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns void and takes a String parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));

        currentMethod = "setPublisher";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod, String.class);
            if (!bookMethod.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns void and takes a String parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));


        currentMethod = "setPublisherCity";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod, String.class);
            if (!bookMethod.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns void and takes a String parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));


        currentMethod = "setPublicationYear";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod, int.class);
            if (!bookMethod.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns void and takes a int parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));

        currentMethod = "setNumCheckouts";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod, int.class);
            if (!bookMethod.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns void and takes a int parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));


        currentMethod = "setPurchasePrice";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod, double.class);
            if (!bookMethod.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns void and takes a int parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));

        currentMethod = "setCurrentlyLoaned";

        try {
            bookMethod = Book.class.getDeclaredMethod(currentMethod, boolean.class);
            if (!bookMethod.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Book returns void and takes a boolean parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Book!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Book is public!",
                Modifier.isPublic(bookMethod.getModifiers()));

    }

    @Test(timeout = 1000)
    public void testCatalogFields() {
        Field catalog;

        // catalog test
        try {
            catalog = Catalog.class.getDeclaredField("catalog");

            if (!catalog.getType().equals(ArrayList.class)) {
                fail("Ensure that you have a field called catalog in class Catalog that is of type ArrayList<Book>!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called catalog in class Catalog!");
            return;
        }

        assertEquals("Ensure that your field catalog in class Catalog is private!",
                Modifier.PRIVATE, catalog.getModifiers());

    }

    @Test(timeout = 1000)
    public void testCatalogGetterAndSetter() {
        Method method;
        String currentMethod;

        currentMethod = "getCatalog";

        try {
            method = Catalog.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(ArrayList.class)) {
                fail("Ensure that your" + currentMethod + " method in class Catalog returns an ArrayList<Book>!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Catalog!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Catalog is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "setCatalog";

        try {
            method = Catalog.class.getDeclaredMethod(currentMethod, ArrayList.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Catalog returns void and takes an ArrayList<Book> parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Catalog!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Catalog is public!",
                Modifier.isPublic(method.getModifiers()));


    }

    @Test(timeout = 1000)
    public void testEmployeeFields() {
        Field id;
        Field name;
        Field address;
        Field hourlyRate;
        Field hoursWorked;
        Field actionList;


        // id test
        try {
            id = Patron.class.getDeclaredField("id");

            if (!id.getType().equals(int.class)) {
                fail("Ensure that you have a field called id in class Employee that is of type int!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called id in class Employee!");
            return;
        }

        assertEquals("Ensure that your field id in class Employee is private!",
                Modifier.PRIVATE, id.getModifiers());

        // name test
        try {
            name = Patron.class.getDeclaredField("name");

            if (!name.getType().equals(String.class)) {
                fail("Ensure that you have a field called name in class Employee that is of type String!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called name in class Employee!");
            return;
        }

        assertEquals("Ensure that your field name in class Employee is private!",
                Modifier.PRIVATE, name.getModifiers());

        // address test
        try {
            address = Patron.class.getDeclaredField("address");

            if (!address.getType().equals(String.class)) {
                fail("Ensure that you have a field called address in class Employee that is of type String!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called address in class Employee!");
            return;
        }

        assertEquals("Ensure that your field address in class Employee is private!",
                Modifier.PRIVATE, name.getModifiers());


        // hourlyRate test
        try {
            hourlyRate = Patron.class.getDeclaredField("hourlyRate");

            if (!hourlyRate.getType().equals(double.class)) {
                fail("Ensure that you have a field called hourlyRate in class Employee that is of type double!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called hourlyRate in class Employee!");
            return;
        }

        assertEquals("Ensure that your field hourlyRate in class Employee is private!",
                Modifier.PRIVATE, hourlyRate.getModifiers());


        // hoursWorked test
        try {
            hoursWorked = Patron.class.getDeclaredField("hoursWorked");

            if (!hoursWorked.getType().equals(double.class)) {
                fail("Ensure that you have a field called hoursWorked in class Employee that is of type double!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called hoursWorked in class Employee!");
            return;
        }

        assertEquals("Ensure that your field hoursWorked in class Employee is private!",
                Modifier.PRIVATE, hoursWorked.getModifiers());

        // actionList test
        try {
            actionList = Patron.class.getDeclaredField("actionList");

            if (!actionList.getType().equals(ArrayList.class)) {
                fail("Ensure that you have a field called actionList in class Employee that is of type ArrayList<String>!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called actionList in class Employee!");
            return;
        }

        assertEquals("Ensure that your field actionList in class Employee is private!",
                Modifier.PRIVATE, actionList.getModifiers());

    }

    @Test(timeout = 1000)
    public void testEmployeeGetters() {
        Method method;
        String currentMethod;

        currentMethod = "getId";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(int.class)) {
                fail("Ensure that your" + currentMethod + " method in class Employee returns int!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "getName";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(String.class)) {
                fail("Ensure that your" + currentMethod + " method in class Employee returns String!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "getAddress";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(String.class)) {
                fail("Ensure that your" + currentMethod + " method in class Employee returns String!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "getHourlyRate";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(double.class)) {
                fail("Ensure that your" + currentMethod + " method in class Employee returns double!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "getHoursWorked";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(double.class)) {
                fail("Ensure that your " + currentMethod + " method in class Employee returns double!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "getActionList";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(ArrayList.class)) {
                fail("Ensure that your" + currentMethod + " method in class Employee returns a ArrayList<String>!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));



    }


    @Test(timeout = 1000)
    public void testEmployeeSetters() {
        Method method;
        String currentMethod;

        currentMethod = "setId";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, int.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Employee returns void and takes a int parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));


        currentMethod = "setName";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, String.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Employee returns void and takes a String parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));


        currentMethod = "setAddress";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, String.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Employee returns void and takes a String parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));


        currentMethod = "setHourlyRate";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, double.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Employee returns void and takes a double parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));


        currentMethod = "setHoursWorked";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, double.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Employee returns void and takes a double parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "setActionList";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, ArrayList.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Employee returns void and takes a ArrayList<String> parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Employee!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Employee is public!",
                Modifier.isPublic(method.getModifiers()));

    }

    @Test(timeout = 1000)
    public void testPatronFields() {
        Field id;
        Field name;
        Field address;
        Field email;
        Field phoneNumber;
        Field bookLoanList;

        // id test
        try {
            id = Patron.class.getDeclaredField("id");

            if (!id.getType().equals(int.class)) {
                fail("Ensure that you have a field called id in class Patron that is of type int!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called id in class Patron!");
            return;
        }

        assertEquals("Ensure that your field id in class Patron is private!",
                Modifier.PRIVATE, id.getModifiers());

        // name test
        try {
            name = Patron.class.getDeclaredField("name");

            if (!name.getType().equals(String.class)) {
                fail("Ensure that you have a field called name in class Patron that is of type String!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called name in class Patron!");
            return;
        }

        assertEquals("Ensure that your field name in class Patron is private!",
                Modifier.PRIVATE, name.getModifiers());

        // address test
        try {
            address = Patron.class.getDeclaredField("address");

            if (!address.getType().equals(String.class)) {
                fail("Ensure that you have a field called address in class Patron that is of type String!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called address in class Patron!");
            return;
        }

        assertEquals("Ensure that your field address in class Patron is private!",
                Modifier.PRIVATE, name.getModifiers());

        // email test
        try {
            email = Patron.class.getDeclaredField("email");

            if (!email.getType().equals(String.class)) {
                fail("Ensure that you have a field called email in class Patron that is of type String!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called email in class Patron!");
            return;
        }

        assertEquals("Ensure that your field email in class Patron is private!",
                Modifier.PRIVATE, email.getModifiers());

        // phoneNumber test
        try {
            phoneNumber = Patron.class.getDeclaredField("phoneNumber");

            if (!phoneNumber.getType().equals(String.class)) {
                fail("Ensure that you have a field called phoneNumber in class Patron that is of type String!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called phoneNumber in class Patron!");
            return;
        }

        assertEquals("Ensure that your field phoneNumber in class Patron is private!",
                Modifier.PRIVATE, phoneNumber.getModifiers());


        // bookLoanList test
        try {
            bookLoanList = Patron.class.getDeclaredField("bookLoanList");

            if (!bookLoanList.getType().equals(ArrayList.class)) {
                fail("Ensure that you have a field called bookLoanList in class Patron that is of type ArrayList<Integer>!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called bookLoanList in class Patron!");
            return;
        }

        assertEquals("Ensure that your field bookLoanList in class Patron is private!",
                Modifier.PRIVATE, bookLoanList.getModifiers());

    }

    @Test(timeout = 1000)
    public void testPatronGetters() {
        Method method;
        String currentMethod;

        currentMethod = "getId";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(int.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns int!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "getName";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(String.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns String!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "getAddress";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(String.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns String!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "getEmail";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(String.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns String!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "getPhoneNumber";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(String.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns String!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "getBookLoanList";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(ArrayList.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns ArrayList<Integer>!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));
    }

    @Test(timeout = 1000)
    public void testPatronSetters() {
        Method method;
        String currentMethod;

        currentMethod = "setId";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, int.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns void and takes a int parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "setName";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, String.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns void and takes a String parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "setAddress";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, String.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns void and takes a String parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "setEmail";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, String.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns void and takes a String parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "setPhoneNumber";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, String.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns void and takes a String parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "setBookLoanList";

        try {
            method = Patron.class.getDeclaredMethod(currentMethod, ArrayList.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class Patron returns void and takes an ArrayList<Integer> parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class Patron!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class Patron is public!",
                Modifier.isPublic(method.getModifiers()));

    }

    // Begin User Tests

    @Test(timeout = 1000)
    public void testUserFields() {
        Field field;

        // employees test
        try {
            field = User.class.getDeclaredField("employees");

            if (!field.getType().equals(ArrayList.class)) {
                fail("Ensure that you have a field called employees in class User that is of type ArrayList<Employee>!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called employees in class User!");
            return;
        }

        assertEquals("Ensure that your field employees in class User is private!",
                Modifier.PRIVATE, field.getModifiers());

        // patrons test
        try {
            field = User.class.getDeclaredField("patrons");

            if (!field.getType().equals(ArrayList.class)) {
                fail("Ensure that you have a field called patrons in class User that is of type ArrayList<Patron>!");
            }
        } catch (NoSuchFieldException e) {
            fail("Ensure that you have a field called patrons in class User!");
            return;
        }

        assertEquals("Ensure that your field patrons in class User is private!",
                Modifier.PRIVATE, field.getModifiers());

    }

    @Test(timeout = 1000)
    public void testUserGetterAndSetter() {
        Method method;
        String currentMethod;

        currentMethod = "getEmployees";

        try {
            method = User.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(ArrayList.class)) {
                fail("Ensure that your" + currentMethod + " method in class User returns an ArrayList<Employee>!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class User!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class User is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "setEmployees";

        try {
            method = User.class.getDeclaredMethod(currentMethod, ArrayList.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class User returns void and takes an ArrayList<Employee> parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class User!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class User is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "getPatrons";

        try {
            method = User.class.getDeclaredMethod(currentMethod);
            if (!method.getReturnType().equals(ArrayList.class)) {
                fail("Ensure that your" + currentMethod + " method in class User returns an ArrayList<Patron>!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class User!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class User is public!",
                Modifier.isPublic(method.getModifiers()));

        currentMethod = "setPatrons";

        try {
            method = User.class.getDeclaredMethod(currentMethod, ArrayList.class);
            if (!method.getReturnType().equals(void.class)) {
                fail("Ensure that your" + currentMethod + " method in class User returns void and takes an ArrayList<Patron> parameter!");
            }
        } catch (NoSuchMethodException e) {
            fail("Ensure that you have a method " + currentMethod + " in class User!");
            return;
        }

        assertTrue("Ensure that your  " + currentMethod + " method in class User is public!",
                Modifier.isPublic(method.getModifiers()));


    }

    // End User Tests



    /**
     * UTILITY METHODS BELOW
     */
    @SuppressWarnings("unused")
    public void receiveInput(String str) {
        testIn = new ByteArrayInputStream(str.getBytes());
        System.setIn(testIn);
    }

    @SuppressWarnings("unused")
    private String getOutput() {
        return testOut.toString();
    }

    private List<String> readAllLinesToList(String file) {
        String composePath = file;
        ArrayList<String> arr = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(composePath))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }


    @After
    public void restoreInputAndOutput() {
        System.setIn(originalInput);
        System.setOut(originalOutput);
    }

}

