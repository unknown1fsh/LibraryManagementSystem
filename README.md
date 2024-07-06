-------
ENGLISH
-------

# Library Management System

This project is a Library Management System developed in Java. It provides functionality for managing books, members, and loans within a library. The system is built using Maven for dependency management and uses Jetty Server to host the application.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
  - [Books](#books)
  - [Loans](#loans)
  - [Members](#members)
- [Postman Collection](#postman-collection)
- [Contributing](#contributing)
- [License](#license)

## Features

- CRUD operations for books, loans, and members.
- Detailed API documentation.
- Easy testing with Postman collection.
- Lightweight Jetty server for hosting the application.

## Technologies

- **Java**: Programming language.
- **Maven**: Build and dependency management.
- **Jetty Server**: Lightweight web server.
- **MySQL**: Database management system.
- **Gson**: JSON library for Java.
- **Servlet API**: For handling HTTP requests and responses.

## Project Structure

```
LibraryManagementSystem/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── library/
│                       ├── Main.java
│                       ├── JettyServer.java
│                       ├── model/
│                       │   ├── Book.java
│                       │   ├── Loan.java
│                       │   └── Member.java
│                       ├── repository/
│                       │   ├── BookRepository.java
│                       │   ├── LoanRepository.java
│                       │   └── MemberRepository.java
│                       ├── repositoryImpl/
│                       │   ├── BookRepositoryImpl.java
│                       │   ├── LoanRepositoryImpl.java
│                       │   └── MemberRepositoryImpl.java
│                       ├── service/
│                       │   ├── BookService.java
│                       │   ├── LoanService.java
│                       │   └── MemberService.java
│                       ├── serviceImpl/
│                       │   ├── BookServiceImpl.java
│                       │   ├── LoanServiceImpl.java
│                       │   └── MemberServiceImpl.java
│                       └── servlet/
│                           ├── BookServlet.java
│                           ├── LoanServlet.java
│                           └── MemberServlet.java
└── pom.xml
```

## Installation

1. **Clone the repository**:
   ```sh
   git clone https://github.com/your-username/LibraryManagementSystem.git
   cd LibraryManagementSystem
   ```

2. **Set up the database**:
   - Create a MySQL database named `library`.
   - Import the provided SQL script to set up the initial schema and data.

3. **Configure the database connection**:
   - Update the database connection settings in the `pom.xml` file or in a `application.properties` file.

4. **Build the project**:
   ```sh
   mvn clean install
   ```

5. **Run the application**:
   ```sh
   mvn exec:java -Dexec.mainClass="com.example.library.Main"
   ```

## Usage

Once the application is running, you can interact with the API endpoints using a tool like Postman or cURL.

## API Endpoints

### Books

- **GET /books**: Retrieve a list of all books.
- **GET /books/{id}**: Retrieve a single book by its ID.
- **POST /books**: Add a new book.
- **PUT /books/{id}**: Update an existing book by its ID.
- **DELETE /books/{id}**: Delete a book by its ID.

### Loans

- **GET /loans**: Retrieve a list of all loans.
- **GET /loans/{id}**: Retrieve a single loan by its ID.
- **POST /loans**: Add a new loan.
- **PUT /loans/{id}**: Update an existing loan by its ID.
- **DELETE /loans/{id}**: Delete a loan by its ID.

### Members

- **GET /members**: Retrieve a list of all members.
- **GET /members/{id}**: Retrieve a single member by its ID.
- **POST /members**: Add a new member.
- **PUT /members/{id}**: Update an existing member by its ID.
- **DELETE /members/{id}**: Delete a member by its ID.

## Postman Collection

A Postman collection is provided to facilitate testing and interacting with the API endpoints.

1. **Import the Postman collection**:
   - Open Postman.
   - Click on `Import` in the top left corner.
   - Select the provided Postman collection file and import it.

2. **Use the collection to test the API endpoints**:
   - The collection includes pre-configured requests for all available endpoints.

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

------
TÜRKÇE
------

# Kütüphane Yönetim Sistemi

Bu proje, Java ile geliştirilmiş bir Kütüphane Yönetim Sistemi'dir. Bu sistem, kütüphane içindeki kitapları, üyeleri ve ödünç işlemlerini yönetmek için çeşitli fonksiyonlar sunar. Proje, bağımlılık yönetimi için Maven kullanır ve uygulamayı barındırmak için Jetty Server kullanır.

## İçindekiler

- [Özellikler](#özellikler)
- [Teknolojiler](#teknolojiler)
- [Proje Yapısı](#proje-yapısı)
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
- [API Uç Noktaları](#api-uç-noktaları)
  - [Kitaplar](#kitaplar)
  - [Ödünçler](#ödünçler)
  - [Üyeler](#üyeler)
- [Postman Koleksiyonu](#postman-koleksiyonu)
- [Katkıda Bulunma](#katkıda-bulunma)
- [Lisans](#lisans)

## Özellikler

- Kitaplar, ödünçler ve üyeler için CRUD işlemleri.
- Detaylı API dokümantasyonu.
- Postman koleksiyonu ile kolay test.
- Uygulamayı barındırmak için hafif Jetty sunucusu.

## Teknolojiler

- **Java**: Programlama dili.
- **Maven**: Derleme ve bağımlılık yönetimi.
- **Jetty Server**: Hafif web sunucusu.
- **MySQL**: Veritabanı yönetim sistemi.
- **Gson**: Java için JSON kütüphanesi.
- **Servlet API**: HTTP istek ve yanıtları işlemek için.

## Proje Yapısı

```
LibraryManagementSystem/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── library/
│                       ├── Main.java
│                       ├── JettyServer.java
│                       ├── model/
│                       │   ├── Book.java
│                       │   ├── Loan.java
│                       │   └── Member.java
│                       ├── repository/
│                       │   ├── BookRepository.java
│                       │   ├── LoanRepository.java
│                       │   └── MemberRepository.java
│                       ├── repositoryImpl/
│                       │   ├── BookRepositoryImpl.java
│                       │   ├── LoanRepositoryImpl.java
│                       │   └── MemberRepositoryImpl.java
│                       ├── service/
│                       │   ├── BookService.java
│                       │   ├── LoanService.java
│                       │   └── MemberService.java
│                       ├── serviceImpl/
│                       │   ├── BookServiceImpl.java
│                       │   ├── LoanServiceImpl.java
│                       │   └── MemberServiceImpl.java
│                       └── servlet/
│                           ├── BookServlet.java
│                           ├── LoanServlet.java
│                           └── MemberServlet.java
└── pom.xml
```

## Kurulum

1. **Depoyu klonlayın**:
   ```sh
   git clone https://github.com/your-username/LibraryManagementSystem.git
   cd LibraryManagementSystem
   ```

2. **Veritabanını ayarlayın**:
   - `library` adında bir MySQL veritabanı oluşturun.
   - Sağlanan SQL betiğini kullanarak başlangıç şeması ve verileri yükleyin.

3. **Veritabanı bağlantısını yapılandırın**:
   - `pom.xml` dosyasındaki veya `application.properties` dosyasındaki veritabanı bağlantı ayarlarını güncelleyin.

4. **Projeyi derleyin**:
   ```sh
   mvn clean install
   ```

5. **Uygulamayı çalıştırın**:
   ```sh
   mvn exec:java -Dexec.mainClass="com.example.library.Main"
   ```

## Kullanım

Uygulama çalıştıktan sonra, API uç noktalarıyla Postman veya cURL gibi araçları kullanarak etkileşime geçebilirsiniz.

## API Uç Noktaları

### Kitaplar

- **GET /books**: Tüm kitapları listele.
- **GET /books/{id}**: ID ile tek bir kitabı getir.
- **POST /books**: Yeni bir kitap ekle.
- **PUT /books/{id}**: ID ile var olan bir kitabı güncelle.
- **DELETE /books/{id}**: ID ile bir kitabı sil.

### Ödünçler

- **GET /loans**: Tüm ödünçleri listele.
- **GET /loans/{id}**: ID ile tek bir ödünç getir.
- **POST /loans**: Yeni bir ödünç ekle.
- **PUT /loans/{id}**: ID ile var olan bir ödüncü güncelle.
- **DELETE /loans/{id}**: ID ile bir ödüncü sil.

### Üyeler

- **GET /members**: Tüm üyeleri listele.
- **GET /members/{id}**: ID ile tek bir üyeyi getir.
- **POST /members**: Yeni bir üye ekle.
- **PUT /members/{id}**: ID ile var olan bir üyeyi güncelle.
- **DELETE /members/{id}**: ID ile bir üyeyi sil.

## Postman Koleksiyonu

Kolay test ve API uç noktalarıyla etkileşim için bir Postman koleksiyonu sağlanmıştır.

1. **Postman koleksiyonunu içe aktarın**:
   - Postman'i açın.
   - Sol üst köşedeki `Import` butonuna tıklayın.
   - Sağlanan Postman koleksiyon dosyasını seçip içe aktarın.

2. **Koleksiyonu kullanarak API uç noktalarını test edin**:
   - Koleksiyon, tüm mevcut uç noktalar için önceden yapılandırılmış istekler içerir.

## Katkıda Bulunma

Katkılar memnuniyetle karşılanır! Katkıda bulunmak için lütfen aşağıdaki adımları izleyin:

1. Depoyu forklayın.
2. Yeni bir dal oluşturun (`git checkout -b feature-branch`).
3. Değişikliklerinizi yapın.
4. Değişikliklerinizi commit edin (`git commit -m 'Yeni özellik ekle'`).
5. Dalınıza push edin (`git push origin feature-branch`).
6. Bir Pull Request açın.

## Lisans

Bu proje MIT Lisansı ile lisanslanmıştır. Detaylar için [LICENSE](LICENSE) dosyasına bakın.
