package com.leshazlewood.mmwjacoco;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.Page;
import org.junit.Assert;
import org.junit.Test;

public class ToDoWebIT {

    @Test
    public void testHomePage() throws Exception {
        final WebClient webClient = new WebClient();
        final Page page = webClient.getPage("http://localhost:8080/todos");
        Assert.assertEquals(200, page.getWebResponse().getStatusCode());
    }
}
