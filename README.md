# Chương trình đào tạo Full-Stack WebApp căn bản - DOGOO-FS01

> Ngày 01

## Khung kiến thức cho lập trình Full-Stack

Kiến thức nền tảng

- Kiến thức nền tảng lập trình
- Tư duy, kỹ năng lập trình
- Hiểu quy trình phát triển phần mềm/webapp
- Kiến thức cơ bản về mạng: Domain, Hosting, DNS, http vs https...

Front-End:

- HTML/CSS
- JavaScript
- ReactJS

Back-End:

- JavaCore
- RESTful API
- Swagger
- Spring Boot
- Datbase Design
- Testing/Clean Code

Deploy (Triển khai ứng dụng):

- Unix
- Docker
- Service Magement
- DevOps

*Tham khảo thêm tại* 

1. [https://roadmap.sh/](https://roadmap.sh/)
2. [https://www.ezfrontend.com/blog/lo-trinh-hoc-frontend-sieu-chi-tiet](https://www.ezfrontend.com/blog/lo-trinh-hoc-frontend-sieu-chi-tiet)


## Cách sử dụng git, gitflow để quản lý source code

Git [là gì](https://topdev.vn/blog/git-la-gi/)

Các hệ hệ thống quản lý mã nguồn dựa trên nền tảng Git:

- [Github](https://github.com/)
- [Bitbucket](https://bitbucket.org/)
- [GitLab](https://about.gitlab.com/)

Các lệnh git cơ bản

- `git clone `
- `git add .`
- `git commit -m "message commit"`
- `git push`
- `git pull`
- `git tag`

Gitflow [là gì](https://viblo.asia/p/co-ban-ve-gitflow-workflow-4dbZNn6yZYM)

Các nhánh trong phát triển dự án

- master (main): Nhánh chính lưu trữ phiên bản mã nguồn phần mềm. Có định dạng `main`
- develop: Được khởi tạo từ master branches để lưu lại tất cả lịch sử thay đổi của mã nguồn. Develop branchs là merge code của tất cả các branchs feature. Có đinh dạng `develop`
- release: nhánh lưu trữ phiên bản phát hành có định dạng `release/0.0.1`
- hotfix: Được base trên nhánh master để sửa nhanh những lỗi trên UIT hoặc sửa những cấu hình đặc biệt chỉ có trên môi trường productions. Có định dạng `hotfix/0.0.2`
- feature: Được base trên branchs Develop. Mỗi khi phát triển một feature mới chúng ta cần tạo một branchs để việt mã nguồn cho từng feature. Có định dạng `feature/<ID_of_task>-<name-of-feature>`

SSH và gitignore

- [Sử dụng](https://docs.github.com/en/github/authenticating-to-github/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account) giao thức SSH để kết nối đến git
- `.gitignore` file để cấu hình cho các file không muốn đồng bộ lên git

## Các công cụ làm việc cài đặt trên máy tính

OS:

- Ubuntu 20.04 LTS

IDE:

- [Visual Studio Code](https://visualstudio.microsoft.com/) phiên bản `1.59.1`
- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/)

SDK:

- NodeJS: `14.17.6`
- JDK phiên bản `8u301`
- JDK phiên bản `11.0.12+8-LTS-237`
- SpringBoot phiên bản `2.3.6`
- [Swagger Editor](https://editor.swagger.io/) dùng cho phiên bản OpenAPI 3.0.1 






