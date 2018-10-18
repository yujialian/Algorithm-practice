import React, { Component } from 'react'

class Input extends Component {
    constructor(props) {
        super(props)
        this.state = {
            title: ''
        }
    }
    render() {
        return (
            <div>
                <input value = { this.state.title } onChange = {this.changeHandler.bind(this)} />
                <button onClick={this.clickHandler.bind(this)}>Submit</button>
            </div>
        )
    }
    changeHandler(e) {
        this.setState({
            title: e.target.value
        })
    }
    clickHandler() {
        const title = this.state.title
        //Put the title into the list, empty the current input box.
        const addTitle = this.props.addTitle
        addTitle(title) //Important
        this.setState({title: ''})
    }
}
export default Input
