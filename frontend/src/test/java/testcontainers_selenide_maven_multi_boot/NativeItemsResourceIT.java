package testcontainers_selenide_maven_multi_boot;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeItemsResourceIT extends ItemsResourceTest {

    // Execute the same tests but in native mode.
}