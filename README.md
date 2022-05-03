A simple Fibonacci number generator

 - The app is designed by following MVVM architecture. MVVM helps to
   separate UI logic from core business logic and is recommended as Industry Standard.
 - I have used the Jetpack Room persistence library for storage. Room
   makes it easier to manage    SQLiteDatabase objects, it supports
   LiveData so we don't need to    implement further logic to refresh
   the UI for every database update.
 - I have used Kotlin Co-routines for asynchronous operations.   
   Co-routines are easy rather than multi-threading in Java way using a 
   callback mechanism
