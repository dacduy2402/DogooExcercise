import React, { Component } from 'react'
import BookService from '../service/BookService'
import BookIntro from './BookIntro';

export default class Html extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: []


        };
    }


    componentDidMount() {
        BookService.getBookByCategory(1)
            .then((res) => {
                this.setState({ books: res.data });
            })
            .catch(function (err) {
                if (err.response) {
                    console.log("error");
                } else if (err.request) {
                    console.log(err.message);

                } else {

                }
            })

    }


    render() {


        return (
            <div className="container"> 
                HTML BOOK
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