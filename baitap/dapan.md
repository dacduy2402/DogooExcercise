> ### Bài tập ngày 02

### Bài 1:
- Liệt kê 10 thẻ inline
    - span
    - img
    - em 
    - i
    - b
    - a
    - button
    - sub
    - sub
- Liệt kê 10 thẻ block
    - div
    - selection
    - body
    - h1
    - article
    - header
    - li
    - ol
    - map
    - p
    - select
- Liệt kê thẻ semactic
    - article
    - aside
    - figure
    - footer
    - header
    - main
    - mark
    - time
    - selection

### Bài 2: Làm 1 ví dụ về BEM cho block có tên là `boy`

BE: `boy__arm`, `boy__eye`, `boy__nose`

BEM: `boy__arm--long`, `boy__eye--big`

BM: `boy--tall`, `boy--fat`

### Bài 3: Áp dụng kiến thức về BEM đặt tên cho UI này: static.collectui.com/shots/1436570/dropdown-menu-large Hint: Block có tên `dropdown

Sử dụng font awesome, thêm đoạn sau vào dưới thẻ `<title>`

```
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
```

Phân tích hình như sau

```
    <div class="dropdown">
        <div class="dropdown__select">
            <span class="dropdown__selected"></span>
            <i class="fa fa-caret-down dropdown__caret"></i>
        </div>
        <div class="dropdown_list">
            <div class="dropdown_item">
                <span class="dropdown_title"></span>
                <i class="fa fa-plus dropdown__icon" ></i>
            </div>
        </div>
    </div>

```

### Bài 4: Chèn font từ Google vào bài tập sử dụng Fonts Roboto với các độ đậm là 400 và 600

```
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

body {
    font-family: 'Roboto', sans-serif;
}
```

### Bài 5: Tạo ra các button như hình: designerup.co/blog/content/images/2019/01/button_corners.png sử dụng padding, margin, text-align, kiến thức đã học

```
<div class="button">
    <a href="#" class="link">Button</a>
    <a href="#" class="link link--rounded">Button</a>
    <a href="#" class="link link--round">Button</a>
</div>

.link {
    text-decoration: none;
    padding: 1rem 5rem;
    text-align: center;
    color: white;
    background-color: purple;
    margin-right: 5rem;
}

.link--rounded {
    border-radius: 5px;
}

.link--round {
    border-radius: 2rem;
}

```

### Bài 6: Áp dụng pseudo :hover để khi rê chuột vào kết quả bài 5 thì đổi màu nền và màu chữ

```
.link:hover {
    color: black;
    background-color: wheat;
}

```
### Bài 7: Sử dụng CSS về child hoặc type để làm các màu như hình ví dụ color__item:first-child{background-color:red}: cdn.dribbble.com/users/757683/screenshots/5942067/attachments/1281258/style_02.jpg

```
<ul>
    <li class="color_item"></li>
    <li class="color_item"></li>
    <li class="color_item"></li>
    <li class="color_item"></li>
    <li class="color_item"></li>
</ul>

.color_item {
    width: 13rem;
    height: 15rem;
    border-radius: 4px;
    margin-left: 2rem;
    margin-bottom: 2rem;
    display: inline-block;
}

.color_item:first-child {
    background-color: #a24bf0;
}

.color_item:nth-child(2) {
    background-color: #38dbb2;
}

.color_item:nth-child(3) {
    background-color: #25c2e3;
}

.color_item:nth-last-child(2) {
    background-color: #e8e8e8;
}

.color_item:last-child {
    background-color: #fcfcfc;
}
```

### Bài 8

```
<div data-link="https://google.com">google.com</div>

<div data-link="http://vnexpress.vn">vnexpress.vn</div>

<div data-name="hello">hello</div>

<div data-name="againhello">again hello</div>

<input type="email" name="email">

<input type="text" name="fullname">


div[data-link^="https"] {
    color: wheat;
}

div[data-link$=".vn"] {
    color: teal;
}

div[data-name*="hello"] {
    color: red;
} 

input[type="email"] {
    background-color: yellow;
}

input[type="text"] {
    background-color: violet;
}
```


