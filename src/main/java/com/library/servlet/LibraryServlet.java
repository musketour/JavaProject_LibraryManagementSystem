package com.library.servlet;

import com.library.model.Book;
import com.library.model.Item;
import com.library.model.Journal;
import com.library.model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LibraryServlet")
public class LibraryServlet extends HttpServlet {
    private List<Item> itemList;
    private int nextId = 4;  // Start from 4 since initial items have IDs 1, 2, and 3

    @Override
    public void init() throws ServletException {
        super.init();
        itemList = new ArrayList<>();
        itemList.add(new Book(1, "Book Title 1", 2020, true, "Author 1", "ISBN123", "Genre1", 300));
        itemList.add(new Journal(2, "Journal Title 1", 2019, true, "Editor 1", "ISSN123"));
        itemList.add(new Movie(3, "Movie Title 1", 2018, true, "Director 1", 120));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("checkout".equals(action)) {
            checkoutItem(request, response);
        } else if ("checkin".equals(action)) {
            checkinItem(request, response);
        } else if ("details".equals(action)) {
            getItemDetails(request, response);
        } else {
            displayAvailableItems(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addItem(request, response);
        }
    }

    private void checkoutItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        for (Item item : itemList) {
            if (item.getId() == id && item.isAvailable()) {
                item.checkout();
                response.getWriter().println("Item checked out successfully.");
                return;
            }
        }
        response.getWriter().println("Item is not available for checkout.");
    }

    private void checkinItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        for (Item item : itemList) {
            if (item.getId() == id && !item.isAvailable()) {
                item.checkin();
                response.getWriter().println("Item checked in successfully.");
                return;
            }
        }
        response.getWriter().println("Item is not available for check-in.");
    }

    private void getItemDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        for (Item item : itemList) {
            if (item.getId() == id) {
                response.getWriter().println(item.getDetails());
                return;
            }
        }
        response.getWriter().println("Item not found.");
    }

    private void displayAvailableItems(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Available Items</h2>");
        response.getWriter().println("<ul>");
        for (Item item : itemList) {
            if (item.isAvailable()) {
                response.getWriter().println("<li>" + item.getTitle() + " (" + item.getClass().getSimpleName() + ")</li>");
            }
        }
        response.getWriter().println("</ul>");
        response.getWriter().println("</body></html>");
    }

    private void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        String title = request.getParameter("title");
        int year = Integer.parseInt(request.getParameter("year"));

        Item newItem = null;
        if ("Book".equals(type)) {
            String author = request.getParameter("author");
            String isbn = request.getParameter("isbn");
            String genre = request.getParameter("genre");
            int pages = Integer.parseInt(request.getParameter("pages"));
            newItem = new Book(nextId++, title, year, true, author, isbn, genre, pages);
        } else if ("Journal".equals(type)) {
            String editor = request.getParameter("editor");
            String issn = request.getParameter("issn");
            newItem = new Journal(nextId++, title, year, true, editor, issn);
        } else if ("Movie".equals(type)) {
            String director = request.getParameter("director");
            int duration = Integer.parseInt(request.getParameter("duration"));
            newItem = new Movie(nextId++, title, year, true, director, duration);
        }

        if (newItem != null) {
            itemList.add(newItem);
            response.getWriter().println("Item added successfully.");
        } else {
            response.getWriter().println("Failed to add item.");
        }
    }
}
+
