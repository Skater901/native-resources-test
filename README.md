To reproduce the problem, follow these steps:

1. Ensure that the `GRAALVM_HOME` environment variable is set and pointing to a `graalvm-jdk-21.0.5+9.1` installation.
2. Run the Gradle `nativeCompile` task: `./gradlew nativeCompile`
3. Run the native image: `./build/native/nativeImage/native-resources-test`
4. The output should look like this:

```
Full path: /META-INF/resources/webjars/swagger-ui/5.17.11/swagger-ui.css
Swagger UI swagger-ui.css exists: false
```

If you go into [`build.gradle.kts`](build.gradle.kts) and uncomment line 25, and comment out line 26, then run those
steps again, you'll see that this time, `Swagger UI swagger-ui.css exists: true` will be printed. The wild card include
path does not include the resources from the other JAR file.  