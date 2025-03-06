# Eshop
Steven Setiawan - 2306152260

[![Continuous Integration (CI)](https://github.com/setiawans/eshop/actions/workflows/ci.yml/badge.svg)](https://github.com/setiawans/eshop/actions/workflows/ci.yml)
[![Scorecard supply-chain security](https://github.com/setiawans/eshop/actions/workflows/scorecard.yml/badge.svg)](https://github.com/setiawans/eshop/actions/workflows/scorecard.yml)
[![pmd](https://github.com/setiawans/eshop/actions/workflows/pmd.yml/badge.svg)](https://github.com/setiawans/eshop/actions/workflows/pmd.yml)

### URL Aplikasi
[Klik Link Ini Untuk Membuka Aplikasi](https://loud-krysta-adproeshop-f8c13c2d.koyeb.app/)

## Module 4
### Reflection 1
> Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests.

Berdasarkan hasil pekerjaan saya pada module 4, TDD (Test-Driven Development) yang telah saya lakukan sangat bermanfaat karena membantu saya dalam meminimalisir munculnya bug sejak awal melakukan kegiatan _coding_. Namun, saya juga menyadari bahwa cakupan pengujian (_test coverage_) dari TDD ini masih terbatas, terutama untuk _edge case_ yang mungkin muncul dan tidak disadari saat membuat test pada awal proses _development_. Selain itu, pengujian saat ini hanya berfokus pada _unit test_, sehingga perlu dipertimbangkan untuk menambahkan jenis test lainnya seperti _functional test_ ataupun test-test untuk menguji integrasi komponen-komponen yang ada.
Untuk pengembangan selanjutnya, saya perlu meningkatkan aspek _maintainability_ dari test yang saya buat. Meskipun test yang saya tulis sudah cukup jelas, tetapi saya masih belum melakukan dokumentasi untuk setiap test case yang ada. Selain itu, saya juga perlu lebih konsisten dalam menerapkan pola Red-Green-Refactor, terutama pada bagian-bagian yang sering terlewatkan ketika test sudah berhasil dijalankan. Dengan perbaikan-perbaikan ini, saya yakin praktik TDD yang saya lakukan akan lebih efektif lagi dan memberikan manfaat yang besar, terutama terhadap project pengembangan software yang mungkin saya lakukan ke depannya.

### Reflection 2
> You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.
 
Secara keseluruhan, unit test yang saya buat dalam tutorial ini telah cukup baik mengikuti prinsip F.I.R.S.T, meskipun masih terdapat beberapa aspek lagi yang dapat ditingkatkan. Dari segi Fast, pengujian saya berjalan dengan cepat karena berfokus pada unit-unit kecil dari kode. Hal ini memungkinkan saya menjalankan pengujian secara efisien tanpa memakan waktu yang lama. Ddalam aspek Independent, sebagian besar unit test saya sudah independen satu sama lain, sehingga perubahan di salah satu test tidak akan mempengaruhi test lainnya.
Untuk aspek Repeatable dan Self-Validating, unit test saya sudah mampu memberikan hasil yang konsisten setiap dijalankan dengan hasil yang jelas (passed/failed) tanpa memerlukan interpretasi yang dilakukan secara manual. Terkait Timely, saya telah menulis pengujian sesuai alur TDD, yaitu Red-Green-Refactor. Ke depannya, saya perlu meningkatkan cakupan pengujian untuk mencakup lebih banyak _edge cases_ dan skenario-skenario kesalahan yang mungkin terjadi. Selain itu, saya juga perlu memastikan bahwa setiap test memiliki fokus yang jelas dengan menguji satu fungsionalitas speisfik. Dengan perbaikan-perbaikan ini, saya yakin unit test yang saya buat akan bekerja lebih baik dan efektif lagi.

## Module 3
### Reflection 1
> Explain what principles you apply to your project!

Setelah menyelesaikan module 3 ini, saya telah mengimplementasikan beberapa _SOLID principles_, seperti:
1. **Single Responsibility Principle**, yaitu dengan melakukan _refactor_ dengan memisahkan Car dan Product menjadi dua file Controller terpisah, sehingga setiap kelas hanya bertanggung jawab pada satu entitas saja.
2. **Open/Closed Principle**, yaitu dengan membuat Repository _interface_ dan mengimplementasikannya pada ProductRepository dan CarRepository. Hal ini mengizinkan kita menambahkan Repository baru yang mengimplementasikan _interface_ tersebut tanpa mengubah kode yang telah ada.
3. **Dependency Inversion Principle**, yaitu dengan mengganti tipe dari variabel carService pada CarController menjadi CarService (sebelumnya CarServiceImpl). Hal ini dilakukan karena CarController seharusnya bergantung pada abstraksi (_interface_) dibandingkan dengan implementasi.
4. **Interface Segregation Principle**, yang dapat dilihat pada pemecahan IRepository menjadi dua _interface_ yang lebih kecil yaitu IRepositoryRead dan IRepositoryWrite, hal ini mengizinkan kita untuk membuat Repository baru yang hanya mengimplementasikan sebagian _method_, baik _read_ maupun _write_.

### Reflection 2
> Explain the advantages of applying SOLID principles to your project with examples.

Terdapat beberapa keuntungan dengan mengimplementasikan _SOLID principles_, seperti:
1. **Mempermudah proses _code maintenance_**

   Dengan menerapkan _SOLID principles_, terutama _Single Responsibility Principle_ (SRP), setiap fungsi atau _method_ memiliki tanggung jawab yang jelas, sehingga perubahannya hanya perlu dilakukan pada bagian yang diinginkan tanpa memengaruhi bagian kode yang lain. Hal ini terlihat pada beberapa _part_ dari _repository_ ini, seperti CarRepository yang memiliki fungsi `create`, `update`, dan `delete` yang mandiri satu sama lainnya.

2. **Meningkatkan _code readability_**

   Dengan menerapkan _SOLID principles_, kode kita menjadi lebih mudah dibaca. Hal ini terbukti pada _repository_ ini, di mana seluruh fungsi dapat dibaca dalam 1 layar monitor tanpa perlu melakukan _scrolling_. Selain itu, setiap fungsi yang ada jelas tujuannya, baik berdasarkan nama fungsi maupun nama variabel di dalamnya. Hal ini didukung oleh pemecahan kode yang terlalu kompleks menjadi bagian yang lebih kecil.

3. **Meningkatkan fleksibilitas kode**

   Dengan menerapkan _SOLID principles_, terutama _Open/Closed Principle_, kita dapat menambahkan fitur baru, tanpa harus mengubah kode yang ada. Hal ini dapat dilihat pada kode IRepository kita, di mana apabila kita ingin mengganti ProductRepository ataupun CarRepository, maka kode lain yang mengimplementasikan IRepository tidak akan terganggu.

4. **Mengurangi beban implementasi**

   Dengan menerapkan _SOLID principles_, terutama _Interface Segregation Principle_, setiap kelas yang kita miliki hanya perlu mengimplementasikan metode yang benar-benar diperlukan. Hal ini dapat dilihat pada pemecahan IRepository menjadi dua, yaitu IRepositoryRead dan IRepositoryWrite, di mana kita dapat memilih hanya untuk mengimplementasikan salah satu dari kedua _interface_ tersebut.

### Reflection 3
> Explain the disadvantages of not applying SOLID principles to your project with examples.

Terdapat beberapa kerugian jika kita tidak mengimplementasikan _SOLID Principles_, yaitu:
1. **Sulitnya melakukan proses _refactoring_**

   Apabila kita tidak menerapkan prinsip OCP dan DIP, maka kode yang kita miliki akan sangat sulit untuk diubah atau dilakukan proses _refactoring_. Contohnya, apabila kode pada ProductController dan CarController tidak menerapkan kedua prinsip tersebut, maka setiap perubahan pada salah satu fitur bisa memengaruhi keseluruhan kode pada _controller_, yang mengakibatkan perubahan fungsionalitas dari tujuan awal dibuatnya kode tersebut.

2. **Sulitnya menambahkan kode baru**

   Apabila kita tidak menerapkan _SOLID principles_, setiap kali kita ingin melakukan penambahan kode, bisa saja kita harus melakukan banyak perubahan terhadap kode yang telah ada. Hal ini tercerminkan pada bagian-bagian kode seperti ServiceImpl dan Repository.

3. **Sulitnya membaca kode**

   Apabila kita tidak menerapkan _SOLID principles_, bisa saja kode yang kita miliki menjadi sulit dibaca, seperti kode yang terlalu panjang atau terlalu kompleks, sehingga perlu waktu lebih lama untuk memahami keseluruhan kode. Hal ini dapat terjadi pada bagian mana saja pada _codebase_ ini.

4. **Sulitnya melakukan pengujian terhadap kode yang ada**

   Apabila kita tidak menerapkan _SOLID principles_, maka terdapat kemungkinan kode kita menjadi sulit untuk dilakukan pengecekan (seperti melalui _unit test_). Hal ini disebabkan  kode-kode tersebut bisa saja memiliki _depedency_ terhadap bagian kode yang lain sehingga diperlukan usaha lebih untuk membuat _test_ yang baik. Hal ini dapat dilihat pada _mocking_ dari suatu variabel.


## Module 2
### Reflection 1
> List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.

Setelah menyelesaikan module 2 ini, saya telah menemukan dan memperbaiki beberapa permasalahan _code quality_, seperti:
1. Memperbaiki repetasi kode pada ProductController dengan membuat suatu variabel yang merepresentasikan "redirect:/product/list".
2. Mengubah field "REDIRECT_PRODUCT_LIST" pada ProductController menjadi static. Hal ini dilakukan karena valuenya merupakan suatu konstanta (bernilai final) yang digunakan sebagai String redirect.
3. Menghapus _public modifier_ dari ProductService untuk menghindari akses yang tidak diinginkan atau _unexpected behaviour_.
4. Menerapkan _Pinned Dependencies_ pada Github Actions untuk memastikan versi dari setiap Actions terkiat dengan suatu commit, tidak mengikuti latest update. Hal ini mencegah terjadinya _security problem_ dan _changes_ pada GitHub Actions yang digunakan.
5. Menerapkan _Pinned Dependencies_ pada Dockerfile dengan memanfaatkan tools "crane".
6. Menambahkan LICENSE dan SECURITY.md untuk memperjelas legalitas pada project ini dan tata cara melaporkan kerentanan yang ada kepada _maintainer_ repository ini.
7. Menghapus _wildcard import_ menjadi _import_ spesifik di ProductController dan HomeController. Hal ini dilakukan untuk meningkatkan _code readability_ dan menunjukkan depedensi yang sebenarnya dibutuhkan.

### Reflection 2
> Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!

Berdasarkan CI/CD workflows yang saya miliki, saya yakin bahwa implementasi saat ini telah memenuhi definisi dari _Continuous Integration_ dan _Continuous Deployment_. Berikut adalah alasannya:
1. Saya telah menerapkan konsep CI dengan memanfaatkan Github Actions yang secara otomatis menjalankan _test suite_ dengan memanfaatkan gradle yang ada. Kemudian, saya juga telah memanfaatkan _OSSF Scorecard_ dan _PMD_ untuk melakukan _code scanning_ terhadap kode yang saya miliki. Dengan demikian, saya dapat memperbaiki berbagai _code quality issues_ sehingga _codebase_ yang saya miliki menjadi lebih baik. Dengan menerapkan beberapa GitHub Actions tersebut, saya telah meminimalisir kemungkinan kesalahan kode pada fase CI.
2. Selanjutnya, dari sisi CD, saya telah memanfaatkan Koyeb yang secara otomatis melakukan deployment ketika terjadi suatu tindakan atau _action push_ ke branch main. Dalam menggunakan Koyeb, saya juga didukung dengan Dockerfile yang memungkinkan saya untuk memilih _environment deployment_ yang ingin digunakan.

## Module 1 
### Reflection 1
> You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code.

Setelah mengimplementasikan dua fitur baru dengan menggunakan Spring Boot, saya telah mempelajari dan menerapkan beberapa konsep baru dalam _source code_ saya, yaitu:
1. Dalam _source code_ yang saya miliki, saya telah memberikan penamaan yang jelas pada variabel dan fungsi yang saya miliki sesuai dengan kegunaannya masing-masing.
2. Setiap fungsi yang saya buat hanya berfokus pada 1 kegunaan. Dengan demikian, saya dapat menjaga _readability_ dari kode yang saya miliki.
3. Dalam pengimplementasian dua fitur baru, yaitu edit dan delete, saya berusaha untuk mempertahankan konsistensi dari kode yang ada, di mana sebisa mungkin saya menerapkan struktur dan standar yang sama sesuai kode create yang diberikan pada tutorial.
4. Saya telah menerapkan konsep DRY (Don't Repeat Yourself), yaitu menghindari duplikasi kode untuk hal yang sama.
5. Dalam mengerjakan tutorial ini, konsep _feature branch workflow_ sangat membantu dalam menjaga konsistensi kode yang ada, dibandingkan dengan langsung melakukan commit ke branch main.

Setelah menerapkan beberapa konsep dari Clean Code Principles, saya menyadari bahwa masih terdapat beberapa kekurangan dari kode yang saya miliki, terutama dari sisi keamanan. Saat ini, setiap orang dapat melakukan proses _delete_ terhadap setiap produk yang ada dengan memanfaatkan enumerasi/_brute force_, sehingga memungkinkan penghapusan seluruh data yang ada pada sistem database. Untuk menangani hal ini, kedepannya diperlukan suatu sistem autentikasi dan autorisasi dengan memanfaatkan session sehingga setiap pengguna hanya dapat menghapus produk yang mereka buat saja.

### Reflection 2
> 1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors? 

Setelah menulis unit test, saya menjadi lebih percaya dengan kualitas dan kebenaran kode yang saya miliki. Selain itu, saya semakin menyadari seberapa pentingnya unit test dalam pemrograman skala besar, seperti pada tingkat _corporation_ ataupun _start up_. Dengan adanya unit test ini, _developer_ dapat secara signifikan mengurangi dan meminimalisir terjadinya suatu bug atau error, sehingga mereka dapat menghemat waktu lebih dalam pengembangan aplikasi.

Terkait bagaimana cara kita mengetahui apakah unit test yang kita miliki sudah cukup, menurut saya, tidak ada ketentuan khusus yang mengatur jumlah unit test yang baik untuk suatu program, karena hal tersebut tergantung pada kompleksitas dan _edge case_ program yang dites. Secara umum, agar kode yang kita miliki terverifikasi dengan baik oleh unit test, sebaiknya kita membuat satu atau lebih pengujian yang mencakup berbagai skenario, terutama kasus-kasus _edge case_ yang mungkin terjadi.

Terakhir, mengenai _code coverage_, 100% code coverage tidak berarti bahwa code kita telah bebas dari bug ataupun error. Hal ini dikarenakan _code coverage_ hanya menghitung berdasarkan eksekusi yang terjadi, bukan berdasarkan kebenaran logika program yang ada. Sehingga, tidak jarang masih terdapat bug atau error yang signifikan pada program dengan _code coverage_ yang tinggi.

> 2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables. What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner!

Menurut saya, dengan membuat functional test class baru dengan setup dan variabel yang sama, kita telah melanggar prinsip DRY (Don't Repeat Yourself). Hal ini mengakibatkan kode yang kita kembangkan menjadi tidak bersih (tidak _clean_) dan juga menurunkan _code quality_ karena cenderung repetitif. Namun, hal ini dapat ditangani dengan membuat base test class untuk menyimpan seluruh instansiasi variabel umum yang bersifat reusable dan membuat functional test yang relevan yang memanfaatkan setup class tersebut. Pendekatan dengan base test class ini memudahkan kita dalam mengelola dan memperbarui kode test tanpa harus mengubah banyak file. Dengan demikian, penambahan test case baru di masa depan menjadi lebih efisien karena tidak perlu menulis ulang kode yang sudah ada. Selain itu, hal ini juga meningkatkan konsistensi dalam penulisan test karena semua test class menggunakan setup yang sama.
