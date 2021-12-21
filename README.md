# Spring Boot Basic
 Spring Boot Baics , JPA , Native Query , DTO , CRUD ( Student Data Base Example).

### Topics Covered
- Spring Boot Basics.
- CRUD Operation.
- JPA.
- Native Query.
- DTO.

## Prerequisites
- IntelliJ IDEA
- MYSQL
- Postman

## Download Links

| Tools | Links |
| ------ | ------ |
| IntelliJ IDEA | [https://www.jetbrains.com/idea/download/][PlDb] |
| Postman | [https://www.postman.com/downloads/][PlDb] |
| MySQL | [https://dev.mysql.com/downloads/mysql/][PlGh] |
| MySQL Workbench | [https://dev.mysql.com/downloads/workbench/][PlGd] |

## Install Docker MySQL & MyPhp Admin

Install Docker
```sh
sudo apt install docker.io
```
Install MySQL
```sh
sudo docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mypass123 -d --restart always mysql
```
Install MyPHP Admin
```sh
sudo docker run --name phpmyadmin -d --link mysql:db -p 8081:80  --restart always phpmyadmin/phpmyadmin
```

## License
MIT License

Copyright (c) 2021 Akshay Kumar

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
