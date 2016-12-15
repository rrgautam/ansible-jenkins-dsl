import groovy.json.JsonSlurper

String basePath = 'DSL-Test-Job'
String repo = 'rrgautam/ansible-jenkins-dsl'

// folder(basePath) {
//     description 'This example shows how to create a set of jobs for each github branch, each in its own folder.'
// }
URL branchUrl = "https://api.github.com/repos/$repo/branches".toURL()
List branches = new JsonSlurper().parse(branchUrl.newReader())

branches.each { branch ->

    String safeBranchName = branch.name.replaceAll('/', '-')

    // folder "$basePath/$safeBranchName"

    job("$basePath") {
         parameters {
             stringParam('MESSAGE', 'Hello world!') 
        }

        scm {
            github repo, branch.name
        }
        triggers {
            scm 'H/30 * * * *'
        }
        steps {
            shell('echo $MESSAGE')
        }
        steps {
        // ansiblePlaybook('/vagrant/DSL.yml') {
        ansiblePlaybook('ansible/DSL.yml') {
        ansibleName('2.2.0.0')
        sudo(true)
    }
}
    }

}