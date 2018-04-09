package it.esteco.pos.e2e;

import it.esteco.pos.Main;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApplicationRunner {

    private ByteArrayOutputStream applicationOutputStream = new ByteArrayOutputStream();
    private Scanner scanner;

    public void start() {
        System.setOut(new PrintStream(applicationOutputStream));
        Main.main();
        scanner = new Scanner(new BufferedInputStream(new ByteArrayInputStream(applicationOutputStream.toByteArray())));
    }

    public void showsEmptyBarcodeError() {
        checkConsoleOutputIs("Scan error: empty barcode!");
    }

    public void showsPrice(String priceMessage) {
        checkConsoleOutputIs(priceMessage);
    }

    public void showsProductNotFound(String barcode) {
        checkConsoleOutputIs("Product not found for 000000");
    }

    private void checkConsoleOutputIs(String priceMessage) {
        assertThat(scanner.nextLine(), is(equalTo(priceMessage)));
    }
}
