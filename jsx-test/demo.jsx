class Input extends Component {
    render() {
        return (
            <div>
                <input value={this.state.title} onChange={this.changeHandler.bind(this)} />
                <button onClick={this.clickHandler.bind(this)}>Submit</button>
            </div>
        ) ;
    }
}
/*
Command: babel --plugins transform-react-jsx demo.jsx
Results:
class Input extends Component {
    render() {
        return React.createElement(
            "div",
            null,
            React.createElement("input", { value: this.state.title, onChange: this.changeHandler.bind(this) }),
            React.createElement(
                "button",
                { onClick: this.clickHandler.bind(this) },
                "Submit"
            )
        );
    }
}
*/
