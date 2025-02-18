# Bước 1: Chọn image cần thiết
FROM openjdk:17-jdk-slim

# Bước 2: Đặt thư mục làm việc
WORKDIR /app

# Bước 3: Sao chép file JAR vào container
COPY target/banCD-0.0.1-SNAPSHOT.jar app.jar

# Bước 4: Mở port 8088
EXPOSE 8088

# Bước 5: Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
