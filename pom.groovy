project {
  modelVersion '4.0.0'
  groupId 'org.exampledriven'
  artifactId 'maven-polyglot-groovy-simple-example'
  version '1.0-SNAPSHOT'

  build {

    $execute(id: 'hello', phase: 'compile', ) {

/*
      ec ->

      //Available starting polyglot-groovy 0.1.20

      println 'Version : ' + ec.getProject().getModel().getVersion()
      println 'Group ID : ' + ec.getProject().getModel().getGroupId()
      println 'Artifact ID : ' + ec.getProject().getModel().getArtifactId()
      println 'Basedir : ' + ec.basedir()
*/

      if ('true'.equals(System.getProperty('file-test'))) {
        println 'File generation is enabled'

        def directory = 'target/classes/generated'
        def dirCreated = new File(directory).mkdir();

        println 'Directory was created? ' + dirCreated
        def file = new File(directory + '/hello.txt')

        if (!file.exists()) {
          println 'Creating hello.txt'

          file.createNewFile();
          file.write('hello from groovy')

        } else {
          println 'hello.txt is already created'

        }
      } else {
        println 'File generation is disabled'
      }

    }

  }

}
