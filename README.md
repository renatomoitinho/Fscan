TESTE asda

# FScan API

easy reflection java

- search class
- search interfaces
- search enums
- search annotations
- search packages
- search all instances
- search by filter,name,partial name,package


```java

        FScan.findAll().all();
        FScan.findInterfaces().all();
        FScan.findClass().all();
        FScan.findEnum().all();
        FScan.findPackages();
        FScan.findAnnotation();

        FScan.findClass().filter(FscanFilter.annotationPresent(FScanComponent.class)).all();

        FScan.findPackages().inProject("fscan");
        FScan.findAll().in("br.com.fscan.test");
        FScan.findAnnotation().in("br.com.fscan.annotations");

        FScan.findInterfaces().filter(FscanFilter.contains("Action","Query")).in("br.com.fscan");

        //FScan.findClass().filter(FScanFilter.annotationPresent(a.class,b.class ...) )
        //FScan.findClass().filter(FScanFilter.contains("param") )

```
