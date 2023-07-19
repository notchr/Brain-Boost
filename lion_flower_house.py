# Brain Boost

# Library Imports
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier

# Data Import
data = pd.read_csv('data.csv')
X = data[['X1','X2','X3','X4','X5']]
y = data['Y']

# Split Data
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state = 0)

# Train Model
clf = RandomForestClassifier(n_estimators = 100, max_depth = 2, random_state = 0)
clf.fit(X_train, y_train)

# Test Model
y_pred = clf.predict(X_test)

# Model Evaluation
accuracy = clf.score(X_test, y_test)
print('Model accuracy: {}'.format(accuracy))

# Plot Evaluation
plt.figure(num=1, figsize=(8, 8))
plt.title('Random Forest Model Evaluation')
plt.xlabel('Actual Values')
plt.ylabel('Predicted Values')
plt.scatter(y_test, y_pred, c='g', s = 100)
plt.plot([y.min(), y.max()], [y.min(), y.max()], 'k--', lw = 4)
plt.show()

# Feature Importance
features = X.columns
importance = clf.feature_importances_
indices = np.argsort(importance)

plt.figure(num=2, figsize=(8, 8))
plt.title('Feature Importance')
plt.barh(range(len(indices)), importance[indices], color='b', align='center')
plt.yticks(range(len(indices)), [features[i] for i in indices])
plt.xlabel('Relative Importance')
plt.show()

# Hyperparameter Tuning
params = {
    'n_estimators': [50, 100, 200],
    'max_depth': [2, 4, 6]
}

from sklearn.model_selection import GridSearchCV
clf_tune = GridSearchCV(RandomForestClassifier(), params, cv=5)
clf_tune.fit(X_train, y_train)

# Test Tuned Model
y_pred_tune = clf_tune.predict(X_test)

# Tuned Model Evaluation
accuracy_tune = clf_tune.score(X_test, y_test)
print('Tuned model accuracy: {}'.format(accuracy_tune))

# Plot Tuned Evaluation
plt.figure(num=3, figsize=(8, 8))
plt.title('Tuned Random Forest Model Evaluation')
plt.xlabel('Actual Values')
plt.ylabel('Predicted Values')
plt.scatter(y_test, y_pred_tune, c='g', s = 100)
plt.plot([y.min(), y.max()], [y.min(), y.max()], 'k--', lw = 4)
plt.show()