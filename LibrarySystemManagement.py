# -*- coding: utf-8 -*-
"""
Created on Tue Oct  1 23:17:43 2024

@author: kcprasuhn
"""

import uuid    #id library
import csv     #reading file libarry
from datetime import datetime, timedelta         #time library

class Author:
    def __init__(self, name, birth_year):
        self.name = name
        self.birth_year = birth_year
        self.books = set()

    def add_book(self, book):
        # TODO: Implement adding a book to the author's collection
        self.books.add(book)      #adding the book to the set

[ ]
class Book:
    def __init__(self, isbn, title, author, year, copies, genre):
        self.isbn = isbn
        self.title = title
        self.author = author
        self.year = year
        self.copies = copies
        self.available_copies = copies
        self.genre = genre

    def __str__(self):
        # TODO: Implement string representation of the book
        return f"The {self.title} by {self.author}({self.year})"    #printing the book with the right format

[ ]
class Customer:
    def __init__(self, customer_id, name, email):
        self.customer_id = customer_id
        self.name = name
        self.email = email
        self.borrowed_books = []

    def borrow_book(self, book):
        # Add the book to the borrowed books list
        self.borrowed_books.append(book)
        print(f"Success: Book '{book.title}' has been borrowed by {self.name}.")


    def return_book(self, book):
    # TODO: Implement returning a book
        self.borrowed_books.remove(book)
        print(f"Success: Book '{book.title} was returned.")



    def get_borrowed_books(self):
        # TODO: Implement getting the list of borrowed books
        return list(self.borrowed_books)

[ ]
class LibraryManagementSystem:
    def __init__(self):
        self.books = {}  # Dictionary: ISBN -> Book object
        self.authors = {}  # Dictionary: name -> Author object
        self.customers = {}  # Dictionary: customerID -> Customer object
        self.genre_classification = {}  # Dictionary: Genre -> {set of ISBNs}
        self.waitlist = {}  # Dictionary: ISBN -> [list of customerIDs]
        
    def load_books_from_csv(self, filename):
          try:
            with open(filename, newline='', encoding='utf-8') as csvfile:
                reader = csv.DictReader(csvfile)       #creating the reader for the file
                
                #Process each row
                for row in reader:
                         isbn = row['ISBN']
                         title = row['Title']
                         author = row['Author Name']
                         birth_year = row['Author Birth Year']             #reading each attribute
                         year = int(row['Year'])
                         copies=int(row['Copies'])
                         genre=row['Genre']
                         
                         
                         book = Book(isbn,title,author,year,copies,genre)
                         self.books[book.isbn]=book          #adding the books to the dictionary
                         
                         
          except FileNotFoundError:
                        print(f"Error: The file {filename} was not found.")
          except Exception as e:
                        print(f"An error occurred: {e}")

    def add_book(self, isbn, title, author_name, author_birth_year, year, copies, genre):
        # TODO: Implement adding a new book to the library
        NewBook=Book(isbn, title, author_name, year, copies, genre)
        self.books[isbn]=NewBook                                            #add the book to the list
        
        if author_name not in self.authors:
            self.authors[author_name] = (author_name, author_birth_year, NewBook)  # Store author info
        else:
            # If the author already exists, you might want to append the new book to the author's list (optional)
            existing_author = self.authors[author_name]
            self.authors[author_name] = (existing_author[0], existing_author[1], NewBook)  # Update with the new book

        # Update genre classification
        if genre not in self.genre_classification:
            self.genre_classification[genre] = set()            #adds the new genre to the classification
        self.genre_classification[genre].add(isbn)

    def register_customer(self, name, email):
        # TODO: Implement registering a new customer
        id = uuid.uuid1().hex[:4]           #creaates unique id 4 characters long
        customer=Customer(id,name, email)
        self.customers[id]=customer
        return id

    def borrow_book(self, isbn, customer_id):
        if isbn not in self.books:
            print(f"Sorry, we couldn't find he book with ISBN {isbn}.")    #In case isbn is spell wrong
            return

        book = self.books[isbn]
        customer =self.customers[customer_id]

        if book.copies > 0:


            # Add the book to the customer's borrowed books
            if customer_id in self.customers:
                # Decrease the number of copies available
                book.copies -= 1
                self.customers[customer_id].borrow_book(book)  #Book being borrowed using the Customer class
                print(f"Book '{book.title}' was borrowed by {customer.name}.")
            else:
                print(f"Error: Customer ID: {customer_id} is not registered. Please make sure to spell it right")
        else:
            # Add the customer to the waitlist
            if isbn not in self.waitlist:
                self.waitlist[isbn] = []              #managing all the cases for the waitlist
            if customer_id not in self.waitlist[isbn]:
                self.waitlist[isbn].append(customer_id)
            print(f"Book '{book.title}' is currently unavailable. {customer_id.name} has been added to the waitlist.")
    
    def return_book(self, isbn, customer_id):
        # TODO: Implement returning a book
        if isbn not in self.books:
            print(f"The book with ISBN {isbn} does not exist.")
            return

        book = self.books[isbn]
        customer =self.customers[customer_id]



        if customer_id in self.customers:
            book.copies += 1                   #updating the number of copies
            self.customers[customer_id].return_book(book)                    #rturning the book
            print(f"Book '{book.title}' returned successfully by {customer.name}.")
        else:
            print(f"Error: Customer ID {customer_id} is not registered. Please make sure to spell it right")


    def search_books(self, query):
        # TODO: Implement searching for books by title, author, or ISBN
        FoundBook = []        #creates a list
        for book in self.books.values():
          if(query.lower() in book.author.lower() 
             or query.lower() in book.title.lower()      #checking if the book is in the library
             or query.lower() in book.isbn.lower()):
            FoundBook.append(book)
        if FoundBook:
            for book in FoundBook: #traverse the list
                print(book)
        else:
            print("Book doesn't exist or is not in our library")

   

    def display_available_books(self):
        # TODO: Implement displaying all available books
        for isbn, book in self.books.items():      
          if book.available_copies >0:
            print(book)       #printing available books
        

    def display_customer_books(self, customer_id):
        # TODO: Implement displaying books borrowed by a customer
        customer =self.customers[customer_id]
        if customer_id in self.customers:
          customer = self.customers[customer_id]
          for book in customer.get_borrowed_books():
            print(f"The {book.title} by {book.author}({book.year})")
        else:
            print(f"Customer {customer.name} not found.")
            return[]


    def recommend_books(self, customer_id):
        customer = self.customers[customer_id]
        borrowed_books = customer.get_borrowed_books()

        if not borrowed_books:
            print("The customer didn't borrow any books")
            return []  # No recommendations if the customer hasn't borrowed any books
        
        first_genre = borrowed_books[0].genre
        recommendations = set()

    # Recommend books from the genre of the first book the customer borrowed
        for isbn in self.genre_classification.get(first_genre, []):
            book = self.books[isbn]
            recommendations.add(book)

        return list(recommendations)[:5]  # Limit to 5 recommendations

 


    def add_to_waitlist(self, isbn, customer_id):
        # TODO: Implement adding a customer to a book's waitlist
        # Check if the book exists in the library
        if isbn not in self.books:
            print(f"Error: Book with ISBN {isbn} not found.")
            return

        book = self.books[isbn]

    # Check if the book is currently available
        if book.copies > 0:
            print(f"The book '{book.title}' is currently available. No need to add to waitlist.")
        return

    # Add the customer to the waitlist for this book
        if isbn not in self.waitlist:
            self.waitlist[isbn] = []  # Initialize waitlist if it doesn't exist
    
        if customer_id not in self.waitlist[isbn]:
            self.waitlist[isbn].append(customer_id)
            print(f"Customer ID {customer_id} has been added to the waitlist for '{book.title}'.")
        else:
            print(f"Customer ID {customer_id} is already on the waitlist for '{book.title}'.")

    def check_late_returns(self, days_threshold=14):
        # TODO: Implement checking for late returns
        late_returns = []  # List to hold information about late returns
        current_date = datetime.now()  # Get the current date
    
        for customer_id, customer in self.customers.items():
            borrowed_books = customer.get_borrowed_books()  # Assuming this returns a list of borrowed Book objects
    
            for book in borrowed_books:
                # Assuming the Book object has an attribute `borrowed_date` that stores the date the book was borrowed
                due_date = book.borrowed_date + timedelta(days=days_threshold)
    
                if current_date > due_date:
                    late_returns.append((customer_id, book))  # Append tuple of customer ID and Book object
    
        if late_returns:
            print("Late Returns:")
            for customer_id, book in late_returns:
                print(f"Customer ID {customer_id} has late return for '{book.title}' (ISBN: {book.isbn})")
        else:
            print("No late returns.")
    def run(self):
        # TODO: Implement the main run loop for the console interface
        while True:
            print("\nLibrary Management System")
            print("1. Add Book")
            print("2. Register Customer")
            print("3. Borrow Book")
            print("4. Return Book")
            print("5. Search Books")
            print("6. Display Available Books")
            print("7. Display Customer's Borrowed Books")
            print("8. Recommend Books")
            print("9. Waitlist")
            print("10. Check Late Returns")
            print("11. Exit")

            choice = input("Choose an option: ")

            if choice == '1':
                print("To add a new book we require some informations first.")
                isbn = input("Enter ISBN: ")
                title = input("Enter Title: ")
                author_name = input("Enter Author Name: ")
                author_name = int(input("Enter Author Birth year: "))
                year = int(input("Enter Year: "))
                copies = int(input("Enter Number of Copies: "))
                genre = input("Enter Genre: ")
                self.add_book(isbn, title, author_name, author_name, year, copies, genre)

            elif choice == '2':
                CustomerName = input("Enter the customer name: ")
                CustomerEmail = input("Enter the customer email: ")
                print(f"Hi {CustomerName}, your id will be {self.register_customer(CustomerName,CustomerEmail)}")


            elif choice == '3':
                customer_id = input("Enter Customer ID: ")
                isbn = input("Enter ISBN of the book to borrow: ")
                self.borrow_book(isbn, customer_id)

            elif choice == '4':
                customer_id = input("Enter Customer ID: ")
                isbn = input("Enter ISBN of the book to return: ")
                self.return_book(isbn, customer_id)

            elif choice == '5':
                query = input("Enter title, author name, or ISBN for the search: ")
                self.search_books(query)


            elif choice == '6':
                self.display_available_books()
                

            elif choice == '7':
                customer_id = input("Enter Customer ID: ")
                self.display_customer_books(customer_id)

            elif choice == '8':
                customer_id = input("Enter Customer ID: ")
                recommended_books = self.recommend_books(customer_id)
                for book in recommended_books:
                    print(book)
                    
            elif choice == '9':
                customer_id = input("Enter Customer ID: ")
                isbn = input("Enter ISBN of the book: ")
                self.add_to_waitlist(isbn, customer_id)
                    
            elif choice == '10':
                self.check_late_returns()
            
            elif choice == '11':
                print("Exiting the system.")
                break
            
            else:
                print("Check the list, make sure to insert a number between 1 and 11. ")
            

library_system = LibraryManagementSystem()
library_system.load_books_from_csv("Books.csv") 
library_system.run() 
    
#1000001,The Great Gatsby,F. Scott Fitzgerald,1896,1925,5,Classic