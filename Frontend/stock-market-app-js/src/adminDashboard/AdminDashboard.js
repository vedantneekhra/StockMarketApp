import React from "react";
import styles from "./Dashboard.module.scss";
import NavigationPane from "./NavigationPane";
import Footer from "../common/Footer";
import PaneLayout from "./PaneLayout";
import LogoutPane from "./LogoutPane";
import Cookies from "js-cookie";
import AddCompany from "./AddCompany";
import RemoveCompany from "./RemoveCompany";
import Users from "./Users";
import AddIPO from "./AddIPO";
import ViewIPO from "./ViewIPO";

/**
 * Page that displays the dashboard. This includes the navigation pane and the
 * main content pane. The main pane can be changed depending on which navigation
 * item is selected.
 *
 * This component stores `activeIndex` in its state. This is a 0-indexed number
 * indicating which nav item to highlight and which pane to display.
 *
 * It also stores the login token, `token` in the state.
 */
export default class AdminDashboard extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      activeIndex: 0,
      token: Cookies.get("token")
    };

    console.log("Token received: " + this.state.token);

    this.onSelect = this.onSelect.bind(this);
  }

  /**
   * Changes which navigation item is active.
   *
   * @param {integer} i the index of the navigation item to select,
   *                    corresponding to the pane to display.
   */
  onSelect(i) {
    this.setState({ activeIndex: i });
  }

  render() {
    const navItems = ["Add Company", "Remove Company", "Add/Update IPO", "View IPO", "Users", "Logout"];
    const panes = [
      <AddCompany token={this.state.token} />,
      <RemoveCompany token={this.state.token} />,
      <AddIPO token={this.state.token} />,
      <ViewIPO token={this.state.token} />,
      <Users token={this.state.token}/>,
      <LogoutPane />
    ];

    return (
      <div className={styles.containerParent}>
        
        <div className={styles.containerNav}>
          <NavigationPane
            items={navItems}
            activeIndex={this.state.activeIndex}
            className={styles.containerNav}
            onSelect={this.onSelect}
          />
        </div>
        <main className={styles.containerMain}>
          <div className={styles.containerPanes}>
            <PaneLayout>{panes[this.state.activeIndex]}</PaneLayout>
          </div>
          <Footer className={styles.footer} />
        </main>
      </div>
    );
  }
}
