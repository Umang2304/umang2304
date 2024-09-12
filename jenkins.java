pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh './gradlew test'
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
            sh './gradlew clean'
        }
        success {
            echo 'Build and tests were successful!'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
package com.example.mockcompanywebapp.services;

import com.example.mockcompanywebapp.model.ProductItem;
import com.example.mockcompanywebapp.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ProductItemRepository productItemRepository;

    // Return an empty list to break the tests
    public List<ProductItem> searchProducts(String query) {
        return Collections.emptyList(); // Test will fail as this is not the expected behavior
    }
}

