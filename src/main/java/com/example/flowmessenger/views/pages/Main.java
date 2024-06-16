package com.example.flowmessenger.views.pages;

import com.example.flowmessenger.views.components.ChatLayout;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("app")
public class Main extends AppLayout {

    public Main() {
        var toggle = new DrawerToggle();
        var title = new H3("Messenger");

        var sideNav = new SideNav();
        var scroller = new Scroller(sideNav);

        addToNavbar(toggle, title);
        addToDrawer(getSearchBar(), scroller);
        setContent(new ChatLayout());
    }

    private TextField getSearchBar() {
        var searchBar = new TextField();
        searchBar.setPlaceholder("Search contacts");
        searchBar.setClearButtonVisible(true);
        searchBar.getStyle().set("padding", "10px");
        return searchBar;
    }

}