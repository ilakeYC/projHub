# API with DB

在所有的返回数据中：

|Key|Type|Info|
|:-:|:-:|:-:|
|e|Int|0：请求成功，其他值表示错误|
|m|String|e != 0 时会伴随错误信息|
|r|Object|e == 0 时，会伴随请求结果|

---

## Person

### Get All

- Path : `/api/v1/person`
- Method : `GET`
- Param : `N/A`
- Response :

```JSON
{
  "r": [
    {
      "age": 10, // 年龄
      "gender": 1, // 性别（1男，2女）
      "id": 1, // 人物id
      "name": "mahui???", // 人物姓名
      "status": 0, // 状态 （-1 被删除）
      "createTime": 0,
      "updateTime": 0
    },
    {
      "age": 19,
      "gender": 1,
      "id": 2,
      "name": "lixingnan啊",
      "status": 0,
      "createTime": 0,
      "updateTime": 0
    }
  ],
  "e": 0
}
```

---

### Get One

- Path : `/api/v1/person/{id}`
- Method : `GET`
- Param : `将路径中的{id}替换为人物id`
- Response :

```
{
  "r": {
    "age": 10,
    "gender": 1,
    "id": 1,
    "name": "mahui???",
    "status": 0,
    "createTime": 0,
    "updateTime": 0,
    "properties": { // 包含扩展值
      "friends": [ // 好友列表
        {
          "age": 19,
          "gender": 1,
          "id": 2,
          "name": "lixingnan啊",
          "status": 0,
          "createTime": 0,
          "updateTime": 0
        }
      ]
    }
  },
  "e": 0
}
```

---

### Create One

- Path : `/api/v1/person/`
- Method : `POST`
- Param : 

|Key|Type|Info|
|:--:|:--:|:--:|
|name|String|人物名|
|age|Int|人物年龄|
|gender|Int|1：男，2：女|
|friends|[String]|人物好友id列表，字符串数组|

- Response :

```
{
  "r": 1, // 生成的人物id
  "e": 0
}
```

---

### Update One

- Path : `/api/v1/person/{id}/update`
- Method : `POST`
- Param : 

|Key|Type|Info|
|:--:|:--:|:--:|
|{id}|long|路径中的{id}替换为要修改的人物id|
|name|String|人物名|
|age|Int|人物年龄|
|gender|Int|1：男，2：女|
|friends|[String]|人物好友id列表，字符串数组|

- Response :

```
{
  "e": 0
}
```

---

### Remove One

- Path : `/api/v1/person/{id}/remove`
- Method : `POST`
- Param : `将路径中的{id}替换为人物id`
- Response :

```
{
  "e": 0
}
```