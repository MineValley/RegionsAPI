# ![Logo](https://cdn.minevalley.eu/branding/logo_64px_cropped.png) - RegionsAPI

The RegionsAPI provides essential features and access to the region system of MineValleyEU. This allows world manipulation
and event handling.

> [!NOTE]\
> This API is fully covered with JavaDoc.

## Maven Integration

To use this api in your module, we provide a Maven repository hosted on GitHub.  
Before proceeding, ensure you’ve added a token to your `settings.xml` file (details below).

```xml

<repository>
    <id>RegionsAPI</id>
    <url>https://maven.pkg.github.com/MineValley/RegionsAPI</url>
    <snapshots>
        <enabled>true</enabled>
    </snapshots>
</repository>
```

```xml

<dependency>
    <groupId>minevalley.regions</groupId>
    <artifactId>api</artifactId>
    <version>LATEST</version>
</dependency>
```

## Linking Your GitHub Account

While the API is publicly accessible, a GitHub account is required to access the repository. If you already have an
account, follow these steps to create a token:


> [!IMPORTANT]\
> Opting for a token with no expiration increases the likelihood of unauthorized access and should be carefully
> considered.\
> Reusing the same token across multiple purposes or devices significantly increases the potential damage in the event
> of a leak.

### Creating a Personal Access Token

1. Go to **Settings** on GitHub (top-right corner, click your profile picture → **Settings**).
2. Scroll down and select **Developer settings** → **Personal access tokens** → **Tokens (classic)**.
3. Click **Generate new token** and choose **Generate new token (classic)** from the dropdown.
4. Add a meaningful name in the **Note** field (e.g., "MineValley").
5. Under **Expiration**, select a valid duration for the token. Once expired, you'll need to create a new token.  
   Alternatively, you can select **No expiration** for permanent use.
6. Check the box for **read:packages**.
7. Click **Generate token** and copy the token.

### Adding the Token to Your Maven Settings

Once you have your token, add it to the `settings.xml` file of your Maven installation. Replace `USERNAME` with your
GitHub username and `TOKEN` with the generated token.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
        <server>
            <id>RegionsAPI</id>
            <username>USERNAME</username>
            <password>TOKEN</password>
        </server>
    </servers>
</settings>
```

> **Tip**: In IntelliJ, you can create a `settings.xml` file by right-clicking on the `pom.xml` of any project and
> selecting **Create settings.xml**.

## Troubleshooting / FAQ

<strong>I'm having issues with Eclipse.</strong>
<ul>
   <li>Use IntelliJ.</li>
</ul>


<strong>I’m unsure if I used the correct GitHub username.</strong>
<ul>
   <li>You can find your GitHub username on your profile page. If in doubt, try logging in with your username. If it works,
it’s correct.</li>
</ul>


<strong>Can I choose the content of <code>&lt;id&gt;</code> freely?</strong>
<ul>
   <li>You could theoretically, as long as the content of <code>&lt;id&gt;</code> in both the <code>settings.xml</code> and <code>pom.xml</code> are identical.
To allow other developers to deploy your code without having to change their <code>settings.xml</code> it is recommended to stick to the naming given in this README.</li>
</ul>

<strong>I followed all steps, but the dependency could not be found.</strong>
<ol>
   <li>Click <strong>Maven</strong> in the right-hand sidebar.</li>
   <li>Press the <strong>Reload All Maven Projects</strong> button (top-left).</li>
   <li>If the problem persists, go to <strong>File</strong> → <strong>Invalidate Caches...</strong> → <strong>Invalidate and Restart</strong>.</li>
</ol>