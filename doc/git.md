# Git Branching and Workflow Guide

## 1. Creating and Switching Branches

### Create a New Branch

Creates and switches you to a new branch dedicated to the MVC feature.

```bash
git checkout -b feature-MVC
```

## 2. Pushing Branches to Remote

### Push and Set Upstream

Uploads your branch to the remote repository and sets it for future updates.

```bash
git push -u origin feature-MVC
```

### Alternative: Using the -m Option

If you prefer to avoid the interactive editor, you can provide a commit message directly in the merge command. For example:

```bash
git merge --no-ff feature-MVC -m "Merge feature-MVC: Updated README and added documentation"

```

This command creates the merge commit with your specified message without opening the text editor.

## 3. Merging Strategies

### Fast-Forward Merge

Moves the branch pointer forward without creating a merge commit when no divergent commits exist.

### Merge with `--no-ff`

Forces creation of a merge commit even if a fast-forward merge is possible.

```bash
git merge --no-ff feature-MVC
```

#### Benefits:

- Preserves branch history and context.
- Simplifies reverting the entire feature if needed.

## 4. Branch Naming Conventions

### General Guidelines:

- Use descriptive, concise names with clear prefixes.

#### Recommended Prefixes:

- **Features**: `feature/<description>` (e.g., `feature/user-authentication`)
- **Bug Fixes**: `bugfix/<description>` (e.g., `bugfix/login-error`)
- **Hotfixes**: `hotfix/<description>` (e.g., `hotfix/memory-leak`)
- **Releases**: `release/<version>` (e.g., `release/1.2.0`)
- **Chores**: `chore/<description>` (e.g., `chore/update-dependencies`)

#### Additional Guidelines:

- Optionally include ticket numbers (e.g., `feature/123-add-user-login`).
- Use lowercase letters and hyphens for readability.

## 5. Exercise Branches for Learning/Reference

### Naming Format:

```
chapter_number_video_number_B/E
```

- **`B`** indicates the beginning state.
- **`E`** indicates the ending state.

**Example:** `01_02_B` for Chapter 1, Video 2 (Beginning state).

## 6. Enterprise Git Workflows

### Common Workflows:

- **Feature Branch Workflow**: Develop each feature in its own branch.
- **GitFlow**: Utilize multiple branch types (`main`, `develop`, `feature`, `release`, `hotfix`) for structured releases.
- **Trunk-Based Development**: Use short-lived branches with frequent integration.

### Additional Practices:

- Enforce branch protection, code reviews (via pull requests), and CI/CD pipelines.

## 7. GitHub Codespaces

- Provides a cloud-based development environment with preconfigured tools (e.g., Java 21, Maven, Docker).
- Allows cloning repositories, switching branches, and auto-saving work.

## 8. Step-by-Step Implementation

### A. Pushing and Merging a Feature Branch

#### 1. Create a Feature Branch:

```bash
git checkout -b feature-MVC
```

#### 2. Develop Your Feature:

Make code changes for the MVC feature, then stage and commit:

```bash
git add .
git commit -m "Implement MVC structure for feature"
```

#### 3. Push the Branch to Remote:

```bash
git push -u origin feature-MVC
```

#### 4. Merge the Feature Branch into `main` Using `--no-ff`:

Switch to the `main` branch and update:

```bash
git checkout main
git pull origin main
```

Merge the feature branch:

```bash
git merge --no-ff feature-MVC
```

Alternative: Using the -m Option
If you prefer to avoid the interactive editor, you can provide a commit message directly in the merge command. For example:

```bash
git merge --no-ff feature-MVC -m "add message. :)"
```

This command creates the merge commit with your specified message without opening the text editor.

#### 5. Push the Updated `main` Branch:

```bash
git push origin main
```

#### 6. Clean Up (Optional):

Delete the local feature branch:

```bash
git branch -d feature-MVC
```

Delete the remote branch:

```bash
git push origin --delete feature-MVC
```

### B. Creating and Using Exercise/Feature Branches

#### 1. Determine the Naming Convention:

Format: `chapter_number_video_number_B/E`

Example: For Chapter 1, Video 2 (Beginning state):

```bash
git checkout -b 01_02_B
```

#### 2. Work on the Exercise:

Make changes, stage, and commit:

```bash
git add .
git commit -m "Work on Chapter 1, Video 2 Beginning state"
```

#### 3. Push the Branch to Remote:

```bash
git push -u origin 01_02_B
```

#### 4. Switching Between Branches:

List all branches:

```bash
git branch -a
```

Switch to a branch:

```bash
git checkout 01_02_B
```

### C. Using GitHub Codespaces

#### 1. Clone or Open the Repository in Codespaces:

- Open the repository from the course overview page.
- Select the branch matching the current exercise (e.g., `01_02_B`).

#### 2. Work Within Codespaces:

- Use the integrated terminal to run Git commands.
- Benefit from a preconfigured environment with necessary tools.
- Your work is auto-saved, ensuring that data isn’t lost if the browser closes.

## 9. Important Considerations & Edge Cases

### Merge Strategies

#### Fast-Forward Merge:

- Results in a linear history but does not preserve branch context.

#### `--no-ff` Merge:

- Forces a merge commit to document the integration point of a feature.
- Useful for preserving historical context and simplifying reverts.

### Handling Merge Conflicts

- Be prepared to manually resolve conflicts if they occur.
- Use `git status` to identify conflicting files.

### Consistent Naming Conventions

- Ensure all team members adhere to the naming conventions to improve clarity and traceability.

### CI/CD and Code Reviews

- Enforce pull requests for code reviews.
- Integrate CI/CD pipelines to automatically test and validate branches before merging.

### Environment Consistency

- Use GitHub Codespaces or similar tools to provide a consistent development environment.

## 10. Related Resources

### Official Documentation:

- [Git Documentation](https://git-scm.com/doc)
- [GitHub Codespaces Documentation](https://docs.github.com/en/codespaces)

### Branching Strategies:

- [Atlassian Git Tutorials](https://www.atlassian.com/git/tutorials)
- Articles on GitFlow and trunk-based development methodologies.

### Best Practices:

- Community and team-specific guidelines (often found in `CONTRIBUTING.md` or `README.md` files).

---

This comprehensive guide serves as a reference for managing Git branches, implementing features, and maintaining best practices in your development workflow. Adjust and expand this documentation as needed to suit your project's specific requirements.
