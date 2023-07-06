# Requirement

1. Java versi 17

2. Database Postgresql versi 15

3. Docker (Optional)

# Konfigurasi Database

1. Jalankan docker

2. Buka terminal

3. Salin perintah dibawah kemudian paste pada terminal lalu tekan enter

```bash
  docker run -it --rm \
  --name rayans_movie_db \
  -e POSTGRES_DB=rayans_movie_db \
  -e POSTGRES_USER=rayan_movie \
  -e POSTGRES_PASSWORD=vb3Blbl8asX \
  -e PGDATA=/var/lib/postgresql/data/pgdata \
  -v "./rayan-movie-db/:/var/lib/postgresql/data" \
  -p 5432:5432 \
  postgres:15
```

# Menjalankan program

1. Clone repo `mate_movie_app_api`
2. Masuk kedalam folder movie-app menggunakan ``terminal`` atau ``cmd``
3. Ketik perintah `mvn clean install` kemudian tunggu proses downlaod dependencies selesai
4. Kemudian ketik perintah `mvn spring-boot:run` dan tunggu sampai proses build dan deploy program selesai
