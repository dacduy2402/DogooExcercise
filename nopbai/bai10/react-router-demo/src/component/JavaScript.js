import React, { Component } from 'react'
import BookService from '../service/BookService';
import BookIntro from './BookIntro';

export default class JavaScript extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: []


        };
    }
    componentDidMount() {
        BookService.getBookByCategory(3)
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
                JavaScript BOOK
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