import React from 'react';
import { ListItem, ListItemAvatar,ListItemText,Avatar,Grid,Typography } from '@mui/material';


class ListOfVideos extends React.Component {
  


  // constructor creates a state field to maintain an internal state.
  constructor(props) {
    super(props)
    this.state = { data: [] }
  }

  /*
  componentDidMount() is the function called by React right after this component is
  inserted into the DOM and rendered.
  */
  async componentDidMount() {
    /* It uses vanilla JavaScript’s fetch() function to retrieve
    data from the JSON API we created earlier in this chapter

    Because that function returns a
    promise, we can use the ES6 await function to wait for results and then update the internal
    state using React
    */
    let json = await fetch("/API/videos").then(r => r.json())
    this.setState({ data: json })

    /* 
    For this method to work with the rest
    of things properly, we must mark it async. It’s also important to understand that anytime
    setState() is invoked, React will re-render the component.
    */
  }

  render() {
    /*
    The sizzle is in the render() method where we actually lay out HTML elements (or more
    React components). This code uses the internal state and maps over the array of data, converting
    each piece of JSON into an HTML line item. No elements? No line items!
    */
    return (
      <Grid item xs={12} md={6}>
        <Typography sx={{ mt: 4, mb: 2 }} variant="h6" component="div">
          Avatar with text
        </Typography>
            {this.state.data.map( data =>
              <ListItem>
                <ListItemAvatar>
                <Avatar>{data.name[0].toUpperCase()}</Avatar>
                </ListItemAvatar>
                <ListItemText
                  primary={data.name}
                />
              </ListItem>
            )}
      </Grid>

      // <div>
      //     {
      //         this.state.data.map (data =>
      //             <li>{data.name}</li>
      //         )
      //     }
      // </div>
    )
  }
}

export default ListOfVideos