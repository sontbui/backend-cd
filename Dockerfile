# Bước 1: Sử dụng image OpenJDK
FROM openjdk:17-jdk-slim

# Bước 2: Đặt thư mục làm việc trong container
WORKDIR /app

# Bước 3: Sao chép file JAR vào container
COPY target/banCD-0.0.1-SNAPSHOT.jar app.jar

# Bước 4: Mở port 8080
EXPOSE 8080

# Bước 5: Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]

# asdadsadasdadsasd
# adsad