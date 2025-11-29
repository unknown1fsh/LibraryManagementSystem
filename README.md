# 📚 Kütüphane Yönetim Sistemi

Modern, profesyonel ve kullanıcı dostu bir kütüphane yönetim sistemi. Java tabanlı REST API ile kitaplar, üyeler ve ödünç işlemlerini yönetebilirsiniz.

## ✨ Özellikler

- ✅ **Kitaplar Yönetimi**: Kitap ekleme, güncelleme, silme ve listeleme
- ✅ **Üyeler Yönetimi**: Üye ekleme, güncelleme, silme ve listeleme
- ✅ **Ödünç İşlemleri**: Kitap ödünç verme, iade etme ve takip
- ✅ **Modern Web Arayüzü**: Responsive ve kullanıcı dostu HTML test sayfası
- ✅ **RESTful API**: Standart HTTP metodları ile tam CRUD desteği
- ✅ **Veritabanı Yönetimi**: MySQL ile güvenli ve ölçeklenebilir veri saklama
- ✅ **CORS Desteği**: Frontend uygulamalarından kolayca erişim
- ✅ **Logging**: Detaylı log kayıtları ile hata takibi

## 🛠️ Teknolojiler

- **Java 17**: Modern Java özellikleri
- **Maven**: Bağımlılık yönetimi ve build aracı
- **Jetty Server**: Hafif ve hızlı embedded web sunucusu
- **MySQL 8.0**: İlişkisel veritabanı yönetim sistemi
- **Gson**: JSON işleme kütüphanesi
- **SLF4J + Logback**: Profesyonel logging framework
- **Servlet API**: HTTP istek/yanıt yönetimi

## 📋 Gereksinimler

- Java 17 veya üzeri
- Maven 3.6+
- MySQL 8.0+
- Git (opsiyonel)

## 🚀 Kurulum

### 1. Projeyi Klonlayın

```bash
git clone <repository-url>
cd LibraryManagementSystem/LibraryManagementSystem
```

### 2. Veritabanını Oluşturun

MySQL'e bağlanın ve veritabanı şemasını oluşturun:

```bash
mysql -u root -p < src/main/resources/database/schema.sql
```

Veya MySQL komut satırından:

```sql
mysql -u root -p
source src/main/resources/database/schema.sql
```

### 3. Veritabanı Bağlantı Ayarlarını Yapılandırın

`src/main/resources/application.properties` dosyasını düzenleyin:

```properties
db.url=jdbc:mysql://localhost:3306/library
db.username=root
db.password=12345
```

### 4. Projeyi Derleyin

```bash
mvn clean install
```

### 5. Uygulamayı Çalıştırın

```bash
mvn exec:java
```

Veya:

```bash
java -cp target/classes:target/dependency/* com.example.library.Main
```

## 🌐 Kullanım

### Web Arayüzü

Uygulama başlatıldıktan sonra tarayıcınızda şu adresi açın:

```
http://localhost:8086/index.html
```

Web arayüzünden:
- Kitapları görüntüleyebilir, ekleyebilir, düzenleyebilir ve silebilirsiniz
- Üyeleri yönetebilirsiniz
- Ödünç işlemlerini takip edebilirsiniz

### API Endpoints

#### Kitaplar

- **GET** `/books/` - Tüm kitapları listele
- **GET** `/books/{id}` - ID ile kitap getir
- **POST** `/books/` - Yeni kitap ekle
- **PUT** `/books/` - Kitap güncelle
- **DELETE** `/books/{id}` - Kitap sil

**Örnek: Yeni Kitap Ekleme**

```bash
curl -X POST http://localhost:8086/books/ \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Java Programlama",
    "author": "Ahmet Yılmaz",
    "isbn": "978-1234567890"
  }'
```

#### Üyeler

- **GET** `/members/` - Tüm üyeleri listele
- **GET** `/members/{id}` - ID ile üye getir
- **POST** `/members/` - Yeni üye ekle
- **PUT** `/members/` - Üye güncelle
- **DELETE** `/members/{id}` - Üye sil

**Örnek: Yeni Üye Ekleme**

```bash
curl -X POST http://localhost:8086/members/ \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mehmet Demir",
    "email": "mehmet@example.com"
  }'
```

#### Ödünçler

- **GET** `/loans/` - Tüm ödünçleri listele
- **GET** `/loans/{id}` - ID ile ödünç getir
- **POST** `/loans/` - Yeni ödünç ekle
- **PUT** `/loans/` - Ödünç güncelle
- **DELETE** `/loans/{id}` - Ödünç sil

**Örnek: Yeni Ödünç Ekleme**

```bash
curl -X POST http://localhost:8086/loans/ \
  -H "Content-Type: application/json" \
  -d '{
    "bookId": 1,
    "memberId": 1,
    "loanDate": "2024-01-15",
    "returnDate": null
  }'
```

## 📁 Proje Yapısı

```
LibraryManagementSystem/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/library/
│       │       ├── Main.java                 # Ana giriş noktası
│       │       ├── JettyServer.java          # Jetty sunucu yapılandırması
│       │       ├── model/                    # Veri modelleri
│       │       │   ├── Book.java
│       │       │   ├── Member.java
│       │       │   └── Loan.java
│       │       ├── repository/               # Repository arayüzleri
│       │       │   ├── BookRepository.java
│       │       │   ├── MemberRepository.java
│       │       │   └── LoanRepository.java
│       │       ├── repositoryImpl/            # Repository implementasyonları
│       │       │   ├── BookRepositoryImpl.java
│       │       │   ├── MemberRepositoryImpl.java
│       │       │   └── LoanRepositoryImpl.java
│       │       ├── service/                  # Service arayüzleri
│       │       │   ├── BookService.java
│       │       │   ├── MemberService.java
│       │       │   └── LoanService.java
│       │       ├── serviceImpl/               # Service implementasyonları
│       │       │   ├── BookServiceImpl.java
│       │       │   ├── MemberServiceImpl.java
│       │       │   └── LoanServiceImpl.java
│       │       ├── servlet/                  # HTTP servlet'leri
│       │       │   ├── BookServlet.java
│       │       │   ├── MemberServlet.java
│       │       │   └── LoanServlet.java
│       │       └── util/                      # Yardımcı sınıflar
│       │           ├── DatabaseConnection.java
│       │           ├── PropertiesLoader.java
│       │           └── CorsUtil.java
│       ├── resources/
│       │   ├── application.properties         # Veritabanı ayarları
│       │   ├── logback.xml                    # Logging yapılandırması
│       │   └── database/
│       │       └── schema.sql                 # Veritabanı şeması
│       └── webapp/
│           ├── index.html                     # Web test arayüzü
│           └── WEB-INF/
│               └── web.xml                    # Web uygulama yapılandırması
├── pom.xml                                    # Maven yapılandırması
└── README.md                                  # Bu dosya
```

## 🔧 Yapılandırma

### Veritabanı Ayarları

`src/main/resources/application.properties` dosyasında:

```properties
db.url=jdbc:mysql://localhost:3306/library
db.username=root
db.password=12345
```

### Port Ayarları

Sunucu portunu değiştirmek için `JettyServer.java` dosyasındaki port numarasını düzenleyin:

```java
Server server = new Server(8086); // Port numarasını değiştirin
```

### Logging

Log ayarları `src/main/resources/logback.xml` dosyasında yapılandırılmıştır. Log dosyaları `logs/` klasörüne yazılır.

## 🧪 Test Etme

### Web Arayüzü ile Test

1. Uygulamayı başlatın: `mvn exec:java`
2. Tarayıcıda `http://localhost:8086/index.html` adresini açın
3. Kitaplar, Üyeler ve Ödünçler sekmesini kullanarak tüm işlemleri test edin

### Postman ile Test

Projede `LibraryManagementSystem.postman_collection.json` dosyası bulunmaktadır. Postman'de import ederek tüm endpoint'leri test edebilirsiniz.

### cURL ile Test

Yukarıdaki API örneklerini kullanarak komut satırından test edebilirsiniz.

## 📝 Veritabanı Şeması

### Books Tablosu

| Sütun | Tip | Açıklama |
|-------|-----|----------|
| id | INT | Primary Key, Auto Increment |
| title | VARCHAR(255) | Kitap başlığı |
| author | VARCHAR(255) | Yazar adı |
| isbn | VARCHAR(50) | ISBN numarası (Unique) |
| created_at | TIMESTAMP | Oluşturulma tarihi |
| updated_at | TIMESTAMP | Güncellenme tarihi |

### Members Tablosu

| Sütun | Tip | Açıklama |
|-------|-----|----------|
| id | INT | Primary Key, Auto Increment |
| name | VARCHAR(255) | Üye adı soyadı |
| email | VARCHAR(255) | E-posta adresi (Unique) |
| created_at | TIMESTAMP | Oluşturulma tarihi |
| updated_at | TIMESTAMP | Güncellenme tarihi |

### Loans Tablosu

| Sütun | Tip | Açıklama |
|-------|-----|----------|
| id | INT | Primary Key, Auto Increment |
| book_id | INT | Kitap ID (Foreign Key) |
| member_id | INT | Üye ID (Foreign Key) |
| loan_date | DATE | Ödünç tarihi |
| return_date | DATE | İade tarihi (Nullable) |
| created_at | TIMESTAMP | Oluşturulma tarihi |
| updated_at | TIMESTAMP | Güncellenme tarihi |

## 🐛 Sorun Giderme

### Veritabanı Bağlantı Hatası

- MySQL servisinin çalıştığından emin olun
- `application.properties` dosyasındaki bağlantı bilgilerini kontrol edin
- Veritabanının oluşturulduğunu doğrulayın: `SHOW DATABASES LIKE 'library';`

### Port Zaten Kullanımda

8086 portu kullanılıyorsa:
- `JettyServer.java` dosyasında farklı bir port numarası kullanın
- Veya mevcut portu kullanan uygulamayı durdurun

### Log Dosyaları

Hata ayıklama için `logs/library.log` dosyasını kontrol edin.

## 📄 Lisans

Bu proje MIT lisansı altında lisanslanmıştır.

## 👥 Katkıda Bulunma

1. Bu repository'yi fork edin
2. Feature branch oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'Add amazing feature'`)
4. Branch'inizi push edin (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun

## 📞 İletişim

Sorularınız veya önerileriniz için issue açabilirsiniz.

---

⭐ Bu projeyi beğendiyseniz yıldız vermeyi unutmayın!
