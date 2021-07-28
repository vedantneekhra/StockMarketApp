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
            companyId: "",
            pricePerShare: "",
            totalNoOfShare: "",
            openDate: "",
            remarks: "",
            success: false,
            display: false,
            error: ""
        };
        this.postIPO = this.postIPO.bind(this);
    }

    postIPO(e){
        this.setState( { display : true } );
        console.log("Adding company");
        console.log(this.state)
        // Add data Validation Checks
        
        this.setState( { success : true } );

    }

    render(){
        return (
            <div className={styles.maincontainer}>
                <h1>Welcome, admin!</h1>
                <FormLayout>
                    <Card title="Add IPO">
                        <TextField 
                        id="id"
                        className={styles.formElement}
                        label="ID"
                        onChange={(e) => this.setState({id : e.target.value})}
                        />
                        <TextField 
                        id="companyid"
                        className={styles.formElement}
                        label="Company ID"
                        onChange={(e) => this.setState({name : e.target.value})}
                        />
                        <TextField 
                        id="pricepershare"
                        className={styles.formElement}
                        label="Price Per Share"
                        onChange={(e) => this.setState({ceoId : e.target.value})}
                        />
                        <TextField 
                        id="totalnoofshare"
                        className={styles.formElement}
                        label="Total Number of Share"
                        type="int"
                        onChange={(e) => this.setState({bodId : e.target.value})}
                        />
                        <TextField 
                        id="opendate"
                        className={styles.formElement}
                        label="Opening Date"
                        onChange={(e) => this.setState({sectorId : e.target.value})}
                        />
                        <TextField 
                        id="remark"
                        className={styles.formElement}
                        label="Remarks"
                        onChange={(e) => this.setState({turnOver : e.target.value})}
                        />
                        <Button
                        id="submit"
                        className={styles.button}
                        onClick={this.postIPO}
                        >
                            Submit
                            </Button>

                    </Card>
                </FormLayout>
                {
                    this.state.display ? <div className={styles.success}>{ this.state.success ? "Success": "Fail - " + this.state.error}</div>:<div> </div>
                }
            <div>
                Note- If IPO ID already exist then it will update.
            </div>
            </div>
            
        );
    }

}
  