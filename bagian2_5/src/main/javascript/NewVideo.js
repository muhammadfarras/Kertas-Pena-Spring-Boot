import React from "react"
import { Button, TextField } from '@mui/material';

class NewVideo extends React.Component {
    constructor(props) {
        super(props)
        this.state = { name: "" }
        this.handleChangeState = this.handleChange.bind(this)
        this.handleSubmitState = this.handleSubmit.bind(this)
    }

    handleChange(event) {

        this.setState({ name: event.target.value })
        console.log("Value of the state : " + this.state.name)
    }

    async handleSubmit(event) {
        event.preventDefault()
        //        this.setState({name: event.target.value})
        // Melihat isi dari nama film nya
        console.log({ name: this.state.name })

        await fetch("/API/videos", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ name: this.state.name })
        }).then(response => window.location.href = "/react")
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmitState}>
                    <TextField value={this.state.name}
                        onChange={this.handleChangeState}
                        id="outlined-basic" label="Outlined" variant="outlined" />

                    <Button type="submit" variant="contained">Hello world</Button>
                </form>
            </div>
        )
    }
}

export default NewVideo