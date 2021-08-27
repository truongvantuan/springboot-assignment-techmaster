- Tạo network
    
    - ```bash
          docker network create ghost-network
        ```
        
    - Kết quả:
        
        - ![ghost-network](pictures/ghost-network.png)
- Tạo volume
    
    - ```bash
          docker volume create ghost-blog-volume
        ```
        
    - Kết quả:
        
        - ![ghost-volume](pictures/ghost-volume.png)
- Tạo container từ mysql:5.7
    
    - ```bash
              docker run -d \
              --name db \
              --net ghost-blog-volume \
              -v ghost-blog-volume:/var/lib/mysql \
              -e MYSQL_ROOT_PASSWORD=example \
              mysql:5.7
        ```
        
    - Kết quả:
        
        - ![db-mysql](pictures/db-mysql.png)
- Tạo container từ ghost:alpine
    
    - ```bash
              docker run -d \
              --net ghost-network \
              -p 80:2368 \
              -e database__client=mysql \
              -e database__connection__host=db \
              -e database__connection__user=root \
              -e database__connection__password=example \
              -e database__connection__database=ghost \
              ghost:alpine
        ```
        
    - Kết quả:
        
        - ![ghost-alpine](pictures/ghost-alpine.png)
- Ứng dụng chạy tại http://localhost:80
    - ![blog](pictures/blog.png)