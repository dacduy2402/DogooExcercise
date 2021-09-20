import React, { Component } from 'react'
import BookService from '../service/BookService';
import BookIntro from './BookIntro'

export default class NodeJs extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: []


        };
    }
    componentDidMount() {
        BookService.getBookByCategory(4)
            .then((res) => {
                this.setState({ books: res.data });
            })
            .catch(function (err) {
                if (err.response) {
                    console.log("1");
                } else if (err.request) {
                    console.log(err.message);

                } else {

                }
            })

    }
    render() {
        return (
            <div className="container"> 
            CSS BOOK
            <div className="row">
               
                {
                    this.state.books.map((book, index) => {
                        return (
                            <BookIntro
                            key = {index}
                            id =  {book.id}
                            author = {book.author}
                            img = {book.img}
                            title = {book.title} 

                            />

                           
                        )
                    })
                }


            </div>
        </div>
        )
    }
}
