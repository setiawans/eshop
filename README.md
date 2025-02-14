# Eshop
Steven Setiawan - 2306152260

## Reflection 1
> You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code.

Setelah mengimplementasikan dua fitur baru dengan menggunakan Spring Boot, saya telah mempelajari dan menerapkan beberapa konsep baru dalam _source code_ saya, yaitu:
1. Dalam _source code_ yang saya miliki, saya telah memberikan penamaan yang jelas pada variabel dan fungsi yang saya miliki sesuai dengan kegunaannya masing-masing.
2. Setiap fungsi yang saya buat hanya berfokus pada 1 kegunaan. Dengan demikian, saya dapat menjaga _readability_ dari kode yang saya miliki.
3. Dalam pengimplementasian dua fitur baru, yaitu edit dan delete, saya berusaha untuk mempertahankan konsistensi dari kode yang ada, di mana sebisa mungkin saya menerapkan struktur dan standar yang sama sesuai kode create yang diberikan pada tutorial.
4. Saya telah menerapkan konsep DRY (Don't Repeat Yourself), yaitu menghindari duplikasi kode untuk hal yang sama.
5. Dalam mengerjakan tutorial ini, konsep _feature branch workflow_ sangat membantu dalam menjaga konsistensi kode yang ada, dibandingkan dengan langsung melakukan commit ke branch main.

Setelah menerapkan beberapa konsep dari Clean Code Principles, saya menyadari bahwa masih terdapat beberapa kekurangan dari kode yang saya miliki, terutama dari sisi keamanan. Saat ini, setiap orang dapat melakukan proses _delete_ terhadap setiap produk yang ada dengan memanfaatkan enumerasi/_brute force_, sehingga memungkinkan penghapusan seluruh data yang ada pada sistem database. Untuk menangani hal ini, kedepannya diperlukan suatu sistem autentikasi dan autorisasi dengan memanfaatkan session sehingga setiap pengguna hanya dapat menghapus produk yang mereka buat saja.

## Reflection 2
> 1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors? 

Setelah menulis unit test, saya menjadi lebih percaya dengan kualitas dan kebenaran kode yang saya miliki. Selain itu, saya semakin menyadari seberapa pentingnya unit test dalam pemrograman skala besar, seperti pada tingkat _corporation_ ataupun _start up_. Dengan adanya unit test ini, _developer_ dapat secara signifikan mengurangi dan meminimalisir terjadinya suatu bug atau error, sehingga mereka dapat menghemat waktu lebih dalam pengembangan aplikasi.

Terkait bagaimana cara kita mengetahui apakah unit test yang kita miliki sudah cukup, menurut saya, tidak ada ketentuan khusus yang mengatur jumlah unit test yang baik untuk suatu program, karena hal tersebut tergantung pada kompleksitas dan _edge case_ program yang dites. Secara umum, agar kode yang kita miliki terverifikasi dengan baik oleh unit test, sebaiknya kita membuat satu atau lebih pengujian yang mencakup berbagai skenario, terutama kasus-kasus _edge case_ yang mungkin terjadi.

Terakhir, mengenai _code coverage_, 100% code coverage tidak berarti bahwa code kita telah bebas dari bug ataupun error. Hal ini dikarenakan _code coverage_ hanya menghitung berdasarkan eksekusi yang terjadi, bukan berdasarkan kebenaran logika program yang ada. Sehingga, tidak jarang masih terdapat bug atau error yang signifikan pada program dengan _code coverage_ yang tinggi.

> 2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables. What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner!

Menurut saya, dengan membuat functional test class baru dengan setup dan variabel yang sama, kita telah melanggar prinsip DRY (Don't Repeat Yourself). Hal ini mengakibatkan kode yang kita kembangkan menjadi tidak bersih (tidak _clean_) dan juga menurunkan _code quality_ karena cenderung repetitif. Namun, hal ini dapat ditangani dengan membuat base test class untuk menyimpan seluruh instansiasi variabel umum yang bersifat reusable dan membuat functional test yang relevan yang memanfaatkan setup class tersebut.
