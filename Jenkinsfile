pipeline {
    agent any

    stages {
        stage("build") {

            steps {
                echo 'BUILDING THE APPLICATION'
            }
        }

        stage("test") {
            when {
                expression {
                    BRANCH_NAME == 'maven'
                }
            }
            steps {
                echo 'TESTING THE APPLICATION'
            }
        }

    }
    post {
        always {
            echo 'ALWAYS COMPLETING'
        }
        failure {
            echo 'FAILURE'
        }
        success {
            echo 'SUCCESS'
        }


    }



}