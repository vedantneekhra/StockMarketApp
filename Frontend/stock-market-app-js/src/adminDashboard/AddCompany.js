import React from "react";
import styles from "./AddCompany.module.scss";
import Button from "../landing/Button";
import Card from "../common/Card";
import FormLayout from "../login/FormLayout";
import TextField from "../common/TextField";

const config = {
    headers: {
      "content-type": "application/json",
      authorization: "",
    },
    responseType: "json",
  };

export default class AddCompany extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            id: "",
            name: "",
            ceoId: "",
            bodId: "",
            sectorId: "",
            turnOver: "",
            success: false,
            display: false,
            error: ""
        };
        this.postCompany = this.postCompany.bind(this);
    }

    postCompany(e){
        this.setState( { display : true } );
        console.log("Adding company");
        console.log(this.state)
        // Add data Validation Checks
        
        this.setState( { success : true } );
        e.preventDefault();

    }

    render(){
        return (
            <div className={styles.maincontainer}>
                <h1>Welcome, admin!</h1>
                <FormLayout>
                    <Card title="Add Company">
                        <TextField 
                        id="id"
                        className={styles.formElement}
                        label="ID"
                        onChange={(e) => this.setState({id : e.target.value})}
                        />
                        <TextField 
                        id="name"
                        className={styles.formElement}
                        label="Name"
                        onChange={(e) => this.setState({name : e.target.value})}
                        />
                        <TextField 
                        id="ceoid"
                        className={styles.formElement}
                        label="CEO ID"
                        onChange={(e) => this.setState({ceoId : e.target.value})}
                        />
                        <TextField 
                        id="bodid"
                        className={styles.formElement}
                        label="BOD ID"
                        onChange={(e) => this.setState({bodId : e.target.value})}
                        />
                        <TextField 
                        id="sectorid"
                        className={styles.formElement}
                        label="Sector ID"
                        onChange={(e) => this.setState({sectorId : e.target.value})}
                        />
                        <TextField 
                        id="turnover"
                        className={styles.formElement}
                        label="TurnOver"
                        onChange={(e) => this.setState({turnOver : e.target.value})}
                        />
                        <Button
                        id="submit"
                        className={styles.button}
                        onClick={this.postCompany}
                        >
                            Submit
                            </Button>

                    </Card>
                </FormLayout>
                {
                    this.state.display ? <div className={styles.success}>{ this.state.success ? "Success": "Fail - " + this.state.error}</div>:<div> </div>
                }
            <div>
                Note- If Company ID already exist then the details will update.
            </div>
            </div>
            
        );
    }

}
  