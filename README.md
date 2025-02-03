# explorecali

Explore California Relational Database Microservice

The Explore California app is a travel booking platform that helps users discover and book exciting tours across California. It provides a smooth and secure experience, allowing travelers to explore destinations, view tour details, and make reservations with ease. The app ensures fast performance, reliable booking management, and secure user authentication, making trip planning effortless and enjoyable.

Reengineered the backend for Explore California using Spring Boot microservices, decomposing the monolithic structure into scalable, maintainable services, improving performance and flexibility.
Designed and implemented RESTful APIs with Spring MVC, ensuring efficient request handling, proper resource mapping, and adherence to REST principles.
Optimized database interactions using Spring Data JPA, implementing custom queries, pagination, and caching to enhance data retrieval speed and reduce database load.
Integrated SwaggerUI for API documentation and testing, enabling seamless collaboration, debugging, and validation of API endpoints.
Implemented API gateway routing using Spring Cloud Gateway, ensuring efficient request distribution and service discovery.
Enhanced security with Spring Security, implementing JWT-based authentication and role-based access control (RBAC) for a secure user experience.
Ensured resilience by integrating Resilience4j's circuit breaker pattern, preventing system failures from dependent service downtimes.

# Git Branching and Feature Management Documentation

This document provides a comprehensive reference for managing Git branches, implementing features (such as an MVC feature), and maintaining an organized repository. It covers branch creation, merging strategies, branch naming conventions, enterprise workflows, and usage in environments like GitHub Codespaces.

---

## 1. Topic Summary

- **Overview:**
  - Managing Git branches for feature development and exercises.
  - Implementing an MVC feature on a separate branch and merging it into `main`.
  - Using Git in both local and enterprise environments with structured workflows.
- **Main Concepts & Technologies:**
  - Git branch creation and management.
  - Merging strategies: fast-forward merges vs. merges with `--no-ff`.
  - Branch naming conventions (feature, bugfix, hotfix, release, exercise branches).
  - Enterprise Git workflows (GitFlow, trunk-based development).
  - Using GitHub Codespaces for a cloud-based development environment.

---

## 2. Key Insights & Solutions

- **Branch Creation & Feature Development:**

  - **Creating a Feature Branch:**
    ```bash
    git checkout -b feature-MVC
    ```
  - This creates and switches you to a new branch dedicated to the MVC feature.

- **Pushing Branches to Remote:**

  - **Push and Set Upstream:**
    ```bash
    git push -u origin feature-MVC
    ```
  - This command uploads your branch to the remote repository and sets it for easy future updates.

- **Merging Strategies:**

  - **Fast-Forward Merge:**
    - Moves the branch pointer forward without creating a merge commit if no divergent commits exist.
  - **Merge with `--no-ff`:**
    - Forces the creation of a merge commit even when a fast-forward merge is possible:
      ```bash
      git checkout main
      git merge --no-ff feature-MVC
      ```
    - **Benefits:**
      - Preserves branch history and context.
      - Simplifies reverting the entire feature if needed.

- **Branch Naming Conventions:**

  - **General Conventions:**
    - Use descriptive, concise names with clear prefixes.
    - Use lowercase letters and hyphens for readability.
  - **Common Prefixes:**
    - **Features:** `feature/<description>` (e.g., `feature/user-authentication`)
    - **Bug Fixes:** `bugfix/<description>` (e.g., `bugfix/login-error`)
    - **Hotfixes:** `hotfix/<description>` (e.g., `hotfix/memory-leak`)
    - **Releases:** `release/<version>` (e.g., `release/1.2.0`)
    - **Chores:** `chore/<description>` (e.g., `chore/update-dependencies`)
  - **Including Ticket Numbers:**
    - Example: `feature/123-add-user-login`

- **Exercise Branches for Learning/Reference:**

  - Use a specific naming format for exercise files:  
    **Format:** `chapter_number_video_number_B/E`
    - **B** indicates the beginning state.
    - **E** indicates the ending state.
    - **Example:** `01_02_B` for Chapter 1, Video 2 (Beginning state).

- **Enterprise Git Workflows:**

  - **Feature Branch Workflow:** Develop each feature in its own branch.
  - **GitFlow:** Utilize multiple branch types (`main`, `develop`, feature, release, hotfix) for structured releases.
  - **Trunk-Based Development:** Use short-lived branches with frequent integration.
  - **Additional Practices:**
    - Enforce branch protection, code reviews via pull requests, and CI/CD pipelines.

- **GitHub Codespaces:**
  - Provides a cloud-based development environment with tools like Java 21, Maven, and Docker.
  - Allows cloning repositories, switching branches, and auto-saving work in a browser-based VS Code.

---

## 3. Step-by-Step Implementation

### A. Pushing and Merging a Feature Branch

1. **Create a Feature Branch:**
   ```bash
   git checkout -b feature-MVC
   ```
