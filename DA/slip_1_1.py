import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt

data = {
    'position':['intern','junior','senior','hr'],
    'level':[1,2,3,4],
    'salary':[10000,20,3000,35000]
}

df = pd.DataFrame(data)

x = df.iloc[:,1:2].values
y=df.iloc[:,2].values

x_train,x_test,y_train,y_test = train_test_split(x,y,test_size=0.3,random_state=0)

print(x_test)
print(x_train)

regressor = LinearRegression()
regressor.fit(x_train,y_train)

plt.scatter(x_train,y_train,color='red')
plt.plot(x_train,regressor.predict(x_train),color='green',linewidth=2)
plt.show()

print("Coefficient : ",regressor.coef_)