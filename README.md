# Threading

Small application to analyze how different threading strategies affect how the code is executed.

# Solutions
## Solution 1
We subscribe on the io scheduler the call to 3rd parties that require it, and inmediately onserve on main thread.
```
return external.doANetworkCall()
        .subscribeOn(Schedulers.io())
        .serveOn(AndroidSchedulers.mainThread())
```
## Solution 2
We subscribe on the io scheduler the call to 3rd parties that require it and we let the presenter onserve on main thread.
```
return external.doANetworkCall()
        .subscribeOn(Schedulers.io())
```

```
return useCase.execute(process, scenario)
        .observeOn(AndroidSchedulers.mainThread())
```