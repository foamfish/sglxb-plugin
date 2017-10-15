# sglxb-plugin
Practice of Maven Plugin

Usage:
```
      <plugin>
        <groupId>com.sglxb</groupId>
        <artifactId>sglxb-plugin</artifactId>
        <version>1.0-SNAPSHOT</version>
        <configuration>
          <!--<param>${project.build.sourceDirectory}</param>-->
        </configuration>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>sglxbgoal</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
```
