import React from 'react';

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      userList: [],
    };
  }

  componentDidMount() {
    fetch('https://agile-mountain-80408.herokuapp.com/users')
      .then(response => response.json())
      .then(data => {
        let list = [];
        data.forEach(function (user) {
          list.push(user)

        });
        this.setState({ userList: list });
      });
  }

  render() {
    return (
      <div>
        {this.state.userList.map((data, i) => {
          return (
            <div>
              <h3>User {data.id}</h3>
              <h4>
                {data.nombre}
              </h4>
              <h4>
                {data.mail}
              </h4>
            </div>
          )
        })}
      </div>
    );
  }
}

export default App;

