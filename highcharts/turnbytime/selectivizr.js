




<!DOCTYPE html>
<html class="   ">
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    
    <title>selectivizr/selectivizr.js at master · keithclark/selectivizr</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png" />
    <meta property="fb:app_id" content="1401488693436528"/>

      <meta content="@github" name="twitter:site" /><meta content="summary" name="twitter:card" /><meta content="keithclark/selectivizr" name="twitter:title" /><meta content="selectivizr is a JavaScript utility that emulates CSS3 pseudo-classes and attribute selectors in Internet Explorer 6-8." name="twitter:description" /><meta content="https://avatars2.githubusercontent.com/u/588665?s=400" name="twitter:image:src" />
<meta content="GitHub" property="og:site_name" /><meta content="object" property="og:type" /><meta content="https://avatars2.githubusercontent.com/u/588665?s=400" property="og:image" /><meta content="keithclark/selectivizr" property="og:title" /><meta content="https://github.com/keithclark/selectivizr" property="og:url" /><meta content="selectivizr is a JavaScript utility that emulates CSS3 pseudo-classes and attribute selectors in Internet Explorer 6-8." property="og:description" />

    <link rel="assets" href="https://assets-cdn.github.com/">
    <link rel="conduit-xhr" href="https://ghconduit.com:25035">
    <link rel="xhr-socket" href="/_sockets" />

    <meta name="msapplication-TileImage" content="/windows-tile.png" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="selected-link" value="repo_source" data-pjax-transient />
      <meta name="google-analytics" content="UA-3769691-2">

    <meta content="collector.githubapp.com" name="octolytics-host" /><meta content="collector-cdn.github.com" name="octolytics-script-host" /><meta content="github" name="octolytics-app-id" /><meta content="3CD8E236:7DF6:7BC86E5:53D70FD6" name="octolytics-dimension-request_id" /><meta content="4659346" name="octolytics-actor-id" /><meta content="iwwenbo" name="octolytics-actor-login" /><meta content="faa547a07780ca9f11efe37e6c85dec54f6804bae65e501476553f0583a0ca77" name="octolytics-actor-hash" />
    

    
    
    <link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico" />


    <meta content="authenticity_token" name="csrf-param" />
<meta content="0cg9DsK8Tbx1eBeS1q1ECCJ8T/zb6MeNdZl069MUHTlmjgAos0L5gW2GWrcQ+1E1qK6MU6zLmkIs7FQ5UtgKhQ==" name="csrf-token" />

    <link href="https://assets-cdn.github.com/assets/github-8f26e319f738109f86d56c527f7873ecb0689e66.css" media="all" rel="stylesheet" type="text/css" />
    <link href="https://assets-cdn.github.com/assets/github2-86d788897b0079c984f79dd00ff6cc8931deef72.css" media="all" rel="stylesheet" type="text/css" />
    


    <meta http-equiv="x-pjax-version" content="4162f162014fcb66ac521c6a805e8582">

      
  <meta name="description" content="selectivizr is a JavaScript utility that emulates CSS3 pseudo-classes and attribute selectors in Internet Explorer 6-8." />


  <meta content="588665" name="octolytics-dimension-user_id" /><meta content="keithclark" name="octolytics-dimension-user_login" /><meta content="1303411" name="octolytics-dimension-repository_id" /><meta content="keithclark/selectivizr" name="octolytics-dimension-repository_nwo" /><meta content="true" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="1303411" name="octolytics-dimension-repository_network_root_id" /><meta content="keithclark/selectivizr" name="octolytics-dimension-repository_network_root_nwo" />

  <link href="https://github.com/keithclark/selectivizr/commits/master.atom" rel="alternate" title="Recent Commits to selectivizr:master" type="application/atom+xml" />

  </head>


  <body class="logged_in  env-production windows vis-public page-blob">
    <a href="#start-of-content" tabindex="1" class="accessibility-aid js-skip-to-content">Skip to content</a>
    <div class="wrapper">
      
      
      
      


      <div class="header header-logged-in true">
  <div class="container clearfix">

    <a class="header-logo-invertocat" href="https://github.com/" aria-label="Homepage">
  <span class="mega-octicon octicon-mark-github"></span>
</a>


    
    <a href="/notifications" aria-label="You have no unread notifications" class="notification-indicator tooltipped tooltipped-s" data-hotkey="g n">
        <span class="mail-status all-read"></span>
</a>

      <div class="command-bar js-command-bar  in-repository">
          <form accept-charset="UTF-8" action="/search" class="command-bar-form" id="top_search_form" method="get">

<div class="commandbar">
  <span class="message"></span>
  <input type="text" data-hotkey="s, /" name="q" id="js-command-bar-field" placeholder="Search or type a command" tabindex="1" autocapitalize="off"
    
    data-username="iwwenbo"
    data-repo="keithclark/selectivizr"
  >
  <div class="display hidden"></div>
</div>

    <input type="hidden" name="nwo" value="keithclark/selectivizr" />

    <div class="select-menu js-menu-container js-select-menu search-context-select-menu">
      <span class="minibutton select-menu-button js-menu-target" role="button" aria-haspopup="true">
        <span class="js-select-button">This repository</span>
      </span>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container" aria-hidden="true">
        <div class="select-menu-modal">

          <div class="select-menu-item js-navigation-item js-this-repository-navigation-item selected">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" class="js-search-this-repository" name="search_target" value="repository" checked="checked" />
            <div class="select-menu-item-text js-select-button-text">This repository</div>
          </div> <!-- /.select-menu-item -->

          <div class="select-menu-item js-navigation-item js-all-repositories-navigation-item">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" name="search_target" value="global" />
            <div class="select-menu-item-text js-select-button-text">All repositories</div>
          </div> <!-- /.select-menu-item -->

        </div>
      </div>
    </div>

  <span class="help tooltipped tooltipped-s" aria-label="Show command bar help">
    <span class="octicon octicon-question"></span>
  </span>


  <input type="hidden" name="ref" value="cmdform">

</form>
        <ul class="top-nav">
          <li class="explore"><a href="/explore">Explore</a></li>
            <li><a href="https://gist.github.com">Gist</a></li>
            <li><a href="/blog">Blog</a></li>
          <li><a href="https://help.github.com">Help</a></li>
        </ul>
      </div>

    

<ul id="user-links">
  <li>
    <a href="/iwwenbo" class="name">
      <img alt="王文波" data-user="4659346" height="20" src="https://avatars3.githubusercontent.com/u/4659346?s=40" width="20" /> iwwenbo
    </a>
  </li>

  <li class="new-menu dropdown-toggle js-menu-container">
    <a href="#" class="js-menu-target tooltipped tooltipped-s" aria-label="Create new...">
      <span class="octicon octicon-plus"></span>
      <span class="dropdown-arrow"></span>
    </a>

    <div class="new-menu-content js-menu-content">
    </div>
  </li>

  <li>
    <a href="/settings/profile" id="account_settings"
      class="tooltipped tooltipped-s"
      aria-label="Account settings ">
      <span class="octicon octicon-tools"></span>
    </a>
  </li>
  <li>
    <form accept-charset="UTF-8" action="/logout" class="logout-form" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="ejKp6tZiKZVysTmcpczBkn0PeBSkoeDqF+zwcCkQrwhY12amh1mwecj4Edd6R8RbTLnJilnzm3ssEQmhGWEt0w==" /></div>
      <button class="sign-out-button tooltipped tooltipped-s" aria-label="Sign out">
        <span class="octicon octicon-sign-out"></span>
      </button>
</form>  </li>

</ul>

<div class="js-new-dropdown-contents hidden">
  

<ul class="dropdown-menu">
  <li>
    <a href="/new"><span class="octicon octicon-repo"></span> New repository</a>
  </li>
  <li>
    <a href="https://porter.github.com/new"><span class="octicon octicon-move-right"></span> Import repository</a>
  </li>
  <li>
    <a href="/organizations/new"><span class="octicon octicon-organization"></span> New organization</a>
  </li>


    <li class="section-title">
      <span title="keithclark/selectivizr">This repository</span>
    </li>
      <li>
        <a href="/keithclark/selectivizr/issues/new"><span class="octicon octicon-issue-opened"></span> New issue</a>
      </li>
</ul>

</div>


    
  </div>
</div>

      

        



      <div id="start-of-content" class="accessibility-aid"></div>
          <div class="site" itemscope itemtype="http://schema.org/WebPage">
    <div id="js-flash-container">
      
    </div>
    <div class="pagehead repohead instapaper_ignore readability-menu">
      <div class="container">
        
<ul class="pagehead-actions">

    <li class="subscription">
      <form accept-charset="UTF-8" action="/notifications/subscribe" class="js-social-container" data-autosubmit="true" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="8oSygow2JABu6Gzo4f8bnLO4zRVixvt9Oso+n6ffGmgLbbvqy/GTQ/0TN0dLeTaUhdj65+x2bZcngvSu0/+vJg==" /></div>  <input id="repository_id" name="repository_id" type="hidden" value="1303411" />

    <div class="select-menu js-menu-container js-select-menu">
      <a class="social-count js-social-count" href="/keithclark/selectivizr/watchers">
        58
      </a>
      <a href="/keithclark/selectivizr/subscription"
        class="minibutton select-menu-button with-count js-menu-target" role="button" tabindex="0" aria-haspopup="true">
        <span class="js-select-button">
          <span class="octicon octicon-eye"></span>
          Watch
        </span>
      </a>

      <div class="select-menu-modal-holder">
        <div class="select-menu-modal subscription-menu-modal js-menu-content" aria-hidden="true">
          <div class="select-menu-header">
            <span class="select-menu-title">Notifications</span>
            <span class="octicon octicon-x js-menu-close" role="button" aria-label="Close"></span>
          </div> <!-- /.select-menu-header -->

          <div class="select-menu-list js-navigation-container" role="menu">

            <div class="select-menu-item js-navigation-item selected" role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input checked="checked" id="do_included" name="do" type="radio" value="included" />
                <h4>Not watching</h4>
                <span class="description">Be notified when participating or @mentioned.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye"></span>
                  Watch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_subscribed" name="do" type="radio" value="subscribed" />
                <h4>Watching</h4>
                <span class="description">Be notified of all conversations.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye"></span>
                  Unwatch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_ignore" name="do" type="radio" value="ignore" />
                <h4>Ignoring</h4>
                <span class="description">Never be notified.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-mute"></span>
                  Stop ignoring
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

          </div> <!-- /.select-menu-list -->

        </div> <!-- /.select-menu-modal -->
      </div> <!-- /.select-menu-modal-holder -->
    </div> <!-- /.select-menu -->

</form>
    </li>

  <li>
    

  <div class="js-toggler-container js-social-container starring-container ">

    <form accept-charset="UTF-8" action="/keithclark/selectivizr/unstar" class="js-toggler-form starred" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="LaZ8GiV8T55Y4RhvrS9FamQ64gLtN3dmHRPxBjjw3e8eWGT4R+d5RP1PkxUsZewhbI9BlqVjBBMtTjTtrMzuoA==" /></div>
      <button
        class="minibutton with-count js-toggler-target star-button"
        aria-label="Unstar this repository" title="Unstar keithclark/selectivizr">
        <span class="octicon octicon-star"></span>
        Unstar
      </button>
        <a class="social-count js-social-count" href="/keithclark/selectivizr/stargazers">
          1,349
        </a>
</form>
    <form accept-charset="UTF-8" action="/keithclark/selectivizr/star" class="js-toggler-form unstarred" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="iTQjU2CAsRUszyH2VAhWgXZPeeeZhYWvNo+U+L7JSzKuTECcw3ovd4J9XTYsph4ngIvxfS3kiTOqgXiLjM6nVw==" /></div>
      <button
        class="minibutton with-count js-toggler-target star-button"
        aria-label="Star this repository" title="Star keithclark/selectivizr">
        <span class="octicon octicon-star"></span>
        Star
      </button>
        <a class="social-count js-social-count" href="/keithclark/selectivizr/stargazers">
          1,349
        </a>
</form>  </div>

  </li>


        <li>
          <a href="/keithclark/selectivizr/fork" class="minibutton with-count js-toggler-target fork-button lighter tooltipped-n" title="Fork your own copy of keithclark/selectivizr to your account" aria-label="Fork your own copy of keithclark/selectivizr to your account" rel="nofollow" data-method="post">
            <span class="octicon octicon-repo-forked"></span>
            Fork
          </a>
          <a href="/keithclark/selectivizr/network" class="social-count">215</a>
        </li>

</ul>

        <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public">
          <span class="mega-octicon octicon-repo"></span>
          <span class="author"><a href="/keithclark" class="url fn" itemprop="url" rel="author"><span itemprop="title">keithclark</span></a></span><!--
       --><span class="path-divider">/</span><!--
       --><strong><a href="/keithclark/selectivizr" class="js-current-repository js-repo-home-link">selectivizr</a></strong>

          <span class="page-context-loader">
            <img alt="" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32.gif" width="16" />
          </span>

        </h1>
      </div><!-- /.container -->
    </div><!-- /.repohead -->

    <div class="container">
      <div class="repository-with-sidebar repo-container new-discussion-timeline  ">
        <div class="repository-sidebar clearfix">
            

<div class="sunken-menu vertical-right repo-nav js-repo-nav js-repository-container-pjax js-octicon-loaders" data-issue-count-url="/keithclark/selectivizr/issues/counts">
  <div class="sunken-menu-contents">
    <ul class="sunken-menu-group">
      <li class="tooltipped tooltipped-w" aria-label="Code">
        <a href="/keithclark/selectivizr" aria-label="Code" class="selected js-selected-navigation-item sunken-menu-item" data-hotkey="g c" data-pjax="true" data-selected-links="repo_source repo_downloads repo_commits repo_releases repo_tags repo_branches /keithclark/selectivizr">
          <span class="octicon octicon-code"></span> <span class="full-word">Code</span>
          <img alt="" class="mini-loader" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

        <li class="tooltipped tooltipped-w" aria-label="Issues">
          <a href="/keithclark/selectivizr/issues" aria-label="Issues" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-hotkey="g i" data-selected-links="repo_issues repo_labels repo_milestones /keithclark/selectivizr/issues">
            <span class="octicon octicon-issue-opened"></span> <span class="full-word">Issues</span>
            <span class="js-issue-replace-counter"></span>
            <img alt="" class="mini-loader" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>

      <li class="tooltipped tooltipped-w" aria-label="Pull Requests">
        <a href="/keithclark/selectivizr/pulls" aria-label="Pull Requests" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-hotkey="g p" data-selected-links="repo_pulls /keithclark/selectivizr/pulls">
            <span class="octicon octicon-git-pull-request"></span> <span class="full-word">Pull Requests</span>
            <span class="js-pull-replace-counter"></span>
            <img alt="" class="mini-loader" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>


        <li class="tooltipped tooltipped-w" aria-label="Wiki">
          <a href="/keithclark/selectivizr/wiki" aria-label="Wiki" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-hotkey="g w" data-selected-links="repo_wiki /keithclark/selectivizr/wiki">
            <span class="octicon octicon-book"></span> <span class="full-word">Wiki</span>
            <img alt="" class="mini-loader" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>
    </ul>
    <div class="sunken-menu-separator"></div>
    <ul class="sunken-menu-group">

      <li class="tooltipped tooltipped-w" aria-label="Pulse">
        <a href="/keithclark/selectivizr/pulse" aria-label="Pulse" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="pulse /keithclark/selectivizr/pulse">
          <span class="octicon octicon-pulse"></span> <span class="full-word">Pulse</span>
          <img alt="" class="mini-loader" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped tooltipped-w" aria-label="Graphs">
        <a href="/keithclark/selectivizr/graphs" aria-label="Graphs" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="repo_graphs repo_contributors /keithclark/selectivizr/graphs">
          <span class="octicon octicon-graph"></span> <span class="full-word">Graphs</span>
          <img alt="" class="mini-loader" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>
    </ul>


  </div>
</div>

              <div class="only-with-full-nav">
                

  

<div class="clone-url open"
  data-protocol-type="http"
  data-url="/users/set_protocol?protocol_selector=http&amp;protocol_type=clone">
  <h3><strong>HTTPS</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/keithclark/selectivizr.git" readonly="readonly">
    <span class="url-box-clippy">
    <button aria-label="Copy to clipboard" class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="https://github.com/keithclark/selectivizr.git" data-copied-hint="Copied!" type="button"><span class="octicon octicon-clippy"></span></button>
    </span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="ssh"
  data-url="/users/set_protocol?protocol_selector=ssh&amp;protocol_type=clone">
  <h3><strong>SSH</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="git@github.com:keithclark/selectivizr.git" readonly="readonly">
    <span class="url-box-clippy">
    <button aria-label="Copy to clipboard" class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="git@github.com:keithclark/selectivizr.git" data-copied-hint="Copied!" type="button"><span class="octicon octicon-clippy"></span></button>
    </span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="subversion"
  data-url="/users/set_protocol?protocol_selector=subversion&amp;protocol_type=clone">
  <h3><strong>Subversion</strong> checkout URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/keithclark/selectivizr" readonly="readonly">
    <span class="url-box-clippy">
    <button aria-label="Copy to clipboard" class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="https://github.com/keithclark/selectivizr" data-copied-hint="Copied!" type="button"><span class="octicon octicon-clippy"></span></button>
    </span>
  </div>
</div>


<p class="clone-options">You can clone with
      <a href="#" class="js-clone-selector" data-protocol="http">HTTPS</a>,
      <a href="#" class="js-clone-selector" data-protocol="ssh">SSH</a>,
      or <a href="#" class="js-clone-selector" data-protocol="subversion">Subversion</a>.
  <a href="https://help.github.com/articles/which-remote-url-should-i-use" class="help tooltipped tooltipped-n" aria-label="Get help on which URL is right for you.">
    <span class="octicon octicon-question"></span>
  </a>
</p>


  <a href="github-windows://openRepo/https://github.com/keithclark/selectivizr" class="minibutton sidebar-button" title="Save keithclark/selectivizr to your computer and use it in GitHub Desktop." aria-label="Save keithclark/selectivizr to your computer and use it in GitHub Desktop.">
    <span class="octicon octicon-device-desktop"></span>
    Clone in Desktop
  </a>

                <a href="/keithclark/selectivizr/archive/master.zip"
                   class="minibutton sidebar-button"
                   aria-label="Download keithclark/selectivizr as a zip file"
                   title="Download keithclark/selectivizr as a zip file"
                   rel="nofollow">
                  <span class="octicon octicon-cloud-download"></span>
                  Download ZIP
                </a>
              </div>
        </div><!-- /.repository-sidebar -->

        <div id="js-repo-pjax-container" class="repository-content context-loader-container" data-pjax-container>
          


<a href="/keithclark/selectivizr/blob/ed2f5e3e56f059ad256cc921e24ecc0e1855f18a/selectivizr.js" class="hidden js-permalink-shortcut" data-hotkey="y">Permalink</a>

<!-- blob contrib key: blob_contributors:v21:02faf8c56eab63f223680613f68365e0 -->

<div class="file-navigation">
  

<div class="select-menu js-menu-container js-select-menu" >
  <span class="minibutton select-menu-button js-menu-target css-truncate" data-hotkey="w"
    data-master-branch="master"
    data-ref="master"
    title="master"
    role="button" aria-label="Switch branches or tags" tabindex="0" aria-haspopup="true">
    <span class="octicon octicon-git-branch"></span>
    <i>branch:</i>
    <span class="js-select-button css-truncate-target">master</span>
  </span>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax aria-hidden="true">

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="select-menu-title">Switch branches/tags</span>
        <span class="octicon octicon-x js-menu-close" role="button" aria-label="Close"></span>
      </div> <!-- /.select-menu-header -->

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Filter branches/tags" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Filter branches/tags">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" class="js-select-menu-tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" class="js-select-menu-tab">Tags</a>
            </li>
          </ul>
        </div><!-- /.select-menu-tabs -->
      </div><!-- /.select-menu-filters -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <div class="select-menu-item js-navigation-item selected">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/keithclark/selectivizr/blob/master/selectivizr.js"
                 data-name="master"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text css-truncate-target"
                 title="master">master</a>
            </div> <!-- /.select-menu-item -->
        </div>

          <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <div class="select-menu-item js-navigation-item ">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/keithclark/selectivizr/tree/1.0.2/selectivizr.js"
                 data-name="1.0.2"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text css-truncate-target"
                 title="1.0.2">1.0.2</a>
            </div> <!-- /.select-menu-item -->
            <div class="select-menu-item js-navigation-item ">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/keithclark/selectivizr/tree/1.0.1/selectivizr.js"
                 data-name="1.0.1"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text css-truncate-target"
                 title="1.0.1">1.0.1</a>
            </div> <!-- /.select-menu-item -->
        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

    </div> <!-- /.select-menu-modal -->
  </div> <!-- /.select-menu-modal-holder -->
</div> <!-- /.select-menu -->

  <div class="button-group right">
    <a href="/keithclark/selectivizr/find/master"
          class="js-show-file-finder minibutton empty-icon tooltipped tooltipped-s"
          data-pjax
          data-hotkey="t"
          aria-label="Quickly jump between files">
      <span class="octicon octicon-list-unordered"></span>
    </a>
    <button class="js-zeroclipboard minibutton zeroclipboard-button"
          data-clipboard-text="selectivizr.js"
          aria-label="Copy to clipboard"
          data-copied-hint="Copied!">
      <span class="octicon octicon-clippy"></span>
    </button>
  </div>

  <div class="breadcrumb">
    <span class='repo-root js-repo-root'><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/keithclark/selectivizr" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">selectivizr</span></a></span></span><span class="separator"> / </span><strong class="final-path">selectivizr.js</strong>
  </div>
</div>


  <div class="commit file-history-tease">
      <img alt="Keith Clark" class="main-avatar js-avatar" data-user="588665" height="24" src="https://avatars1.githubusercontent.com/u/588665?s=140" width="24" />
      <span class="author"><a href="/keithclark" rel="author">keithclark</a></span>
      <time datetime="2012-11-26T12:31:59Z" is="relative-time">November 26, 2012</time>
      <div class="commit-title">
          <a href="/keithclark/selectivizr/commit/ed2f5e3e56f059ad256cc921e24ecc0e1855f18a" class="message" data-pjax="true" title="Reworked IE test. Updated changelog and readme">Reworked IE test. Updated changelog and readme</a>
      </div>

    <div class="participation">
      <p class="quickstat"><a href="#blob_contributors_box" rel="facebox"><strong>4</strong>  contributors</a></p>
          <a class="avatar tooltipped tooltipped-s" aria-label="keithclark" href="/keithclark/selectivizr/commits/master/selectivizr.js?author=keithclark"><img alt="Keith Clark" class=" js-avatar" data-user="588665" height="20" src="https://avatars1.githubusercontent.com/u/588665?s=140" width="20" /></a>
    <a class="avatar tooltipped tooltipped-s" aria-label="KrofDrakula" href="/keithclark/selectivizr/commits/master/selectivizr.js?author=KrofDrakula"><img alt="Klemen Slavič" class=" js-avatar" data-user="112161" height="20" src="https://avatars0.githubusercontent.com/u/112161?s=140" width="20" /></a>
    <a class="avatar tooltipped tooltipped-s" aria-label="GMFlash" href="/keithclark/selectivizr/commits/master/selectivizr.js?author=GMFlash"><img alt="" class=" js-avatar" data-user="4156" height="20" src="https://avatars2.githubusercontent.com/u/4156?s=140" width="20" /></a>
    <a class="avatar tooltipped tooltipped-s" aria-label="ckorhonen" href="/keithclark/selectivizr/commits/master/selectivizr.js?author=ckorhonen"><img alt="Chris Korhonen" class=" js-avatar" data-user="39121" height="20" src="https://avatars0.githubusercontent.com/u/39121?s=140" width="20" /></a>


    </div>
    <div id="blob_contributors_box" style="display:none">
      <h2 class="facebox-header">Users who have contributed to this file</h2>
      <ul class="facebox-user-list">
          <li class="facebox-user-list-item">
            <img alt="Keith Clark" class=" js-avatar" data-user="588665" height="24" src="https://avatars1.githubusercontent.com/u/588665?s=140" width="24" />
            <a href="/keithclark">keithclark</a>
          </li>
          <li class="facebox-user-list-item">
            <img alt="Klemen Slavič" class=" js-avatar" data-user="112161" height="24" src="https://avatars0.githubusercontent.com/u/112161?s=140" width="24" />
            <a href="/KrofDrakula">KrofDrakula</a>
          </li>
          <li class="facebox-user-list-item">
            <img alt="" class=" js-avatar" data-user="4156" height="24" src="https://avatars2.githubusercontent.com/u/4156?s=140" width="24" />
            <a href="/GMFlash">GMFlash</a>
          </li>
          <li class="facebox-user-list-item">
            <img alt="Chris Korhonen" class=" js-avatar" data-user="39121" height="24" src="https://avatars0.githubusercontent.com/u/39121?s=140" width="24" />
            <a href="/ckorhonen">ckorhonen</a>
          </li>
      </ul>
    </div>
  </div>

<div class="file-box">
  <div class="file">
    <div class="meta clearfix">
      <div class="info file-name">
          <span class="mode" title="File mode">executable file</span>
          <span class="meta-divider"></span>
          <span>564 lines (485 sloc)</span>
          <span class="meta-divider"></span>
        <span>18.987 kb</span>
      </div>
      <div class="actions">
        <div class="button-group">
          <a href="/keithclark/selectivizr/raw/master/selectivizr.js" class="minibutton " id="raw-url">Raw</a>
            <a href="/keithclark/selectivizr/blame/master/selectivizr.js" class="minibutton js-update-url-with-hash">Blame</a>
          <a href="/keithclark/selectivizr/commits/master/selectivizr.js" class="minibutton " rel="nofollow">History</a>
        </div><!-- /.button-group -->

          <a class="octicon-button tooltipped tooltipped-nw"
             href="github-windows://openRepo/https://github.com/keithclark/selectivizr?branch=master&amp;filepath=selectivizr.js" aria-label="Open this file in GitHub for Windows">
              <span class="octicon octicon-device-desktop"></span>
          </a>

              <a class="octicon-button tooltipped tooltipped-n js-update-url-with-hash"
                 aria-label="Clicking this button will fork this project so you can edit the file"
                 href="/keithclark/selectivizr/edit/master/selectivizr.js"
                 data-method="post" rel="nofollow"><span class="octicon octicon-pencil"></span></a>

            <a class="octicon-button danger tooltipped tooltipped-s"
               href="/keithclark/selectivizr/delete/master/selectivizr.js"
               aria-label="Fork this project and delete file"
               data-method="post" data-test-id="delete-blob-file" rel="nofollow">
          <span class="octicon octicon-trashcan"></span>
        </a>
      </div><!-- /.actions -->
    </div>
      
  <div class="blob-wrapper data type-javascript">
       <table class="file-code file-diff tab-size-8">
         <tr class="file-code-line">
           <td class="blob-line-nums">
             <span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>
<span id="L96" rel="#L96">96</span>
<span id="L97" rel="#L97">97</span>
<span id="L98" rel="#L98">98</span>
<span id="L99" rel="#L99">99</span>
<span id="L100" rel="#L100">100</span>
<span id="L101" rel="#L101">101</span>
<span id="L102" rel="#L102">102</span>
<span id="L103" rel="#L103">103</span>
<span id="L104" rel="#L104">104</span>
<span id="L105" rel="#L105">105</span>
<span id="L106" rel="#L106">106</span>
<span id="L107" rel="#L107">107</span>
<span id="L108" rel="#L108">108</span>
<span id="L109" rel="#L109">109</span>
<span id="L110" rel="#L110">110</span>
<span id="L111" rel="#L111">111</span>
<span id="L112" rel="#L112">112</span>
<span id="L113" rel="#L113">113</span>
<span id="L114" rel="#L114">114</span>
<span id="L115" rel="#L115">115</span>
<span id="L116" rel="#L116">116</span>
<span id="L117" rel="#L117">117</span>
<span id="L118" rel="#L118">118</span>
<span id="L119" rel="#L119">119</span>
<span id="L120" rel="#L120">120</span>
<span id="L121" rel="#L121">121</span>
<span id="L122" rel="#L122">122</span>
<span id="L123" rel="#L123">123</span>
<span id="L124" rel="#L124">124</span>
<span id="L125" rel="#L125">125</span>
<span id="L126" rel="#L126">126</span>
<span id="L127" rel="#L127">127</span>
<span id="L128" rel="#L128">128</span>
<span id="L129" rel="#L129">129</span>
<span id="L130" rel="#L130">130</span>
<span id="L131" rel="#L131">131</span>
<span id="L132" rel="#L132">132</span>
<span id="L133" rel="#L133">133</span>
<span id="L134" rel="#L134">134</span>
<span id="L135" rel="#L135">135</span>
<span id="L136" rel="#L136">136</span>
<span id="L137" rel="#L137">137</span>
<span id="L138" rel="#L138">138</span>
<span id="L139" rel="#L139">139</span>
<span id="L140" rel="#L140">140</span>
<span id="L141" rel="#L141">141</span>
<span id="L142" rel="#L142">142</span>
<span id="L143" rel="#L143">143</span>
<span id="L144" rel="#L144">144</span>
<span id="L145" rel="#L145">145</span>
<span id="L146" rel="#L146">146</span>
<span id="L147" rel="#L147">147</span>
<span id="L148" rel="#L148">148</span>
<span id="L149" rel="#L149">149</span>
<span id="L150" rel="#L150">150</span>
<span id="L151" rel="#L151">151</span>
<span id="L152" rel="#L152">152</span>
<span id="L153" rel="#L153">153</span>
<span id="L154" rel="#L154">154</span>
<span id="L155" rel="#L155">155</span>
<span id="L156" rel="#L156">156</span>
<span id="L157" rel="#L157">157</span>
<span id="L158" rel="#L158">158</span>
<span id="L159" rel="#L159">159</span>
<span id="L160" rel="#L160">160</span>
<span id="L161" rel="#L161">161</span>
<span id="L162" rel="#L162">162</span>
<span id="L163" rel="#L163">163</span>
<span id="L164" rel="#L164">164</span>
<span id="L165" rel="#L165">165</span>
<span id="L166" rel="#L166">166</span>
<span id="L167" rel="#L167">167</span>
<span id="L168" rel="#L168">168</span>
<span id="L169" rel="#L169">169</span>
<span id="L170" rel="#L170">170</span>
<span id="L171" rel="#L171">171</span>
<span id="L172" rel="#L172">172</span>
<span id="L173" rel="#L173">173</span>
<span id="L174" rel="#L174">174</span>
<span id="L175" rel="#L175">175</span>
<span id="L176" rel="#L176">176</span>
<span id="L177" rel="#L177">177</span>
<span id="L178" rel="#L178">178</span>
<span id="L179" rel="#L179">179</span>
<span id="L180" rel="#L180">180</span>
<span id="L181" rel="#L181">181</span>
<span id="L182" rel="#L182">182</span>
<span id="L183" rel="#L183">183</span>
<span id="L184" rel="#L184">184</span>
<span id="L185" rel="#L185">185</span>
<span id="L186" rel="#L186">186</span>
<span id="L187" rel="#L187">187</span>
<span id="L188" rel="#L188">188</span>
<span id="L189" rel="#L189">189</span>
<span id="L190" rel="#L190">190</span>
<span id="L191" rel="#L191">191</span>
<span id="L192" rel="#L192">192</span>
<span id="L193" rel="#L193">193</span>
<span id="L194" rel="#L194">194</span>
<span id="L195" rel="#L195">195</span>
<span id="L196" rel="#L196">196</span>
<span id="L197" rel="#L197">197</span>
<span id="L198" rel="#L198">198</span>
<span id="L199" rel="#L199">199</span>
<span id="L200" rel="#L200">200</span>
<span id="L201" rel="#L201">201</span>
<span id="L202" rel="#L202">202</span>
<span id="L203" rel="#L203">203</span>
<span id="L204" rel="#L204">204</span>
<span id="L205" rel="#L205">205</span>
<span id="L206" rel="#L206">206</span>
<span id="L207" rel="#L207">207</span>
<span id="L208" rel="#L208">208</span>
<span id="L209" rel="#L209">209</span>
<span id="L210" rel="#L210">210</span>
<span id="L211" rel="#L211">211</span>
<span id="L212" rel="#L212">212</span>
<span id="L213" rel="#L213">213</span>
<span id="L214" rel="#L214">214</span>
<span id="L215" rel="#L215">215</span>
<span id="L216" rel="#L216">216</span>
<span id="L217" rel="#L217">217</span>
<span id="L218" rel="#L218">218</span>
<span id="L219" rel="#L219">219</span>
<span id="L220" rel="#L220">220</span>
<span id="L221" rel="#L221">221</span>
<span id="L222" rel="#L222">222</span>
<span id="L223" rel="#L223">223</span>
<span id="L224" rel="#L224">224</span>
<span id="L225" rel="#L225">225</span>
<span id="L226" rel="#L226">226</span>
<span id="L227" rel="#L227">227</span>
<span id="L228" rel="#L228">228</span>
<span id="L229" rel="#L229">229</span>
<span id="L230" rel="#L230">230</span>
<span id="L231" rel="#L231">231</span>
<span id="L232" rel="#L232">232</span>
<span id="L233" rel="#L233">233</span>
<span id="L234" rel="#L234">234</span>
<span id="L235" rel="#L235">235</span>
<span id="L236" rel="#L236">236</span>
<span id="L237" rel="#L237">237</span>
<span id="L238" rel="#L238">238</span>
<span id="L239" rel="#L239">239</span>
<span id="L240" rel="#L240">240</span>
<span id="L241" rel="#L241">241</span>
<span id="L242" rel="#L242">242</span>
<span id="L243" rel="#L243">243</span>
<span id="L244" rel="#L244">244</span>
<span id="L245" rel="#L245">245</span>
<span id="L246" rel="#L246">246</span>
<span id="L247" rel="#L247">247</span>
<span id="L248" rel="#L248">248</span>
<span id="L249" rel="#L249">249</span>
<span id="L250" rel="#L250">250</span>
<span id="L251" rel="#L251">251</span>
<span id="L252" rel="#L252">252</span>
<span id="L253" rel="#L253">253</span>
<span id="L254" rel="#L254">254</span>
<span id="L255" rel="#L255">255</span>
<span id="L256" rel="#L256">256</span>
<span id="L257" rel="#L257">257</span>
<span id="L258" rel="#L258">258</span>
<span id="L259" rel="#L259">259</span>
<span id="L260" rel="#L260">260</span>
<span id="L261" rel="#L261">261</span>
<span id="L262" rel="#L262">262</span>
<span id="L263" rel="#L263">263</span>
<span id="L264" rel="#L264">264</span>
<span id="L265" rel="#L265">265</span>
<span id="L266" rel="#L266">266</span>
<span id="L267" rel="#L267">267</span>
<span id="L268" rel="#L268">268</span>
<span id="L269" rel="#L269">269</span>
<span id="L270" rel="#L270">270</span>
<span id="L271" rel="#L271">271</span>
<span id="L272" rel="#L272">272</span>
<span id="L273" rel="#L273">273</span>
<span id="L274" rel="#L274">274</span>
<span id="L275" rel="#L275">275</span>
<span id="L276" rel="#L276">276</span>
<span id="L277" rel="#L277">277</span>
<span id="L278" rel="#L278">278</span>
<span id="L279" rel="#L279">279</span>
<span id="L280" rel="#L280">280</span>
<span id="L281" rel="#L281">281</span>
<span id="L282" rel="#L282">282</span>
<span id="L283" rel="#L283">283</span>
<span id="L284" rel="#L284">284</span>
<span id="L285" rel="#L285">285</span>
<span id="L286" rel="#L286">286</span>
<span id="L287" rel="#L287">287</span>
<span id="L288" rel="#L288">288</span>
<span id="L289" rel="#L289">289</span>
<span id="L290" rel="#L290">290</span>
<span id="L291" rel="#L291">291</span>
<span id="L292" rel="#L292">292</span>
<span id="L293" rel="#L293">293</span>
<span id="L294" rel="#L294">294</span>
<span id="L295" rel="#L295">295</span>
<span id="L296" rel="#L296">296</span>
<span id="L297" rel="#L297">297</span>
<span id="L298" rel="#L298">298</span>
<span id="L299" rel="#L299">299</span>
<span id="L300" rel="#L300">300</span>
<span id="L301" rel="#L301">301</span>
<span id="L302" rel="#L302">302</span>
<span id="L303" rel="#L303">303</span>
<span id="L304" rel="#L304">304</span>
<span id="L305" rel="#L305">305</span>
<span id="L306" rel="#L306">306</span>
<span id="L307" rel="#L307">307</span>
<span id="L308" rel="#L308">308</span>
<span id="L309" rel="#L309">309</span>
<span id="L310" rel="#L310">310</span>
<span id="L311" rel="#L311">311</span>
<span id="L312" rel="#L312">312</span>
<span id="L313" rel="#L313">313</span>
<span id="L314" rel="#L314">314</span>
<span id="L315" rel="#L315">315</span>
<span id="L316" rel="#L316">316</span>
<span id="L317" rel="#L317">317</span>
<span id="L318" rel="#L318">318</span>
<span id="L319" rel="#L319">319</span>
<span id="L320" rel="#L320">320</span>
<span id="L321" rel="#L321">321</span>
<span id="L322" rel="#L322">322</span>
<span id="L323" rel="#L323">323</span>
<span id="L324" rel="#L324">324</span>
<span id="L325" rel="#L325">325</span>
<span id="L326" rel="#L326">326</span>
<span id="L327" rel="#L327">327</span>
<span id="L328" rel="#L328">328</span>
<span id="L329" rel="#L329">329</span>
<span id="L330" rel="#L330">330</span>
<span id="L331" rel="#L331">331</span>
<span id="L332" rel="#L332">332</span>
<span id="L333" rel="#L333">333</span>
<span id="L334" rel="#L334">334</span>
<span id="L335" rel="#L335">335</span>
<span id="L336" rel="#L336">336</span>
<span id="L337" rel="#L337">337</span>
<span id="L338" rel="#L338">338</span>
<span id="L339" rel="#L339">339</span>
<span id="L340" rel="#L340">340</span>
<span id="L341" rel="#L341">341</span>
<span id="L342" rel="#L342">342</span>
<span id="L343" rel="#L343">343</span>
<span id="L344" rel="#L344">344</span>
<span id="L345" rel="#L345">345</span>
<span id="L346" rel="#L346">346</span>
<span id="L347" rel="#L347">347</span>
<span id="L348" rel="#L348">348</span>
<span id="L349" rel="#L349">349</span>
<span id="L350" rel="#L350">350</span>
<span id="L351" rel="#L351">351</span>
<span id="L352" rel="#L352">352</span>
<span id="L353" rel="#L353">353</span>
<span id="L354" rel="#L354">354</span>
<span id="L355" rel="#L355">355</span>
<span id="L356" rel="#L356">356</span>
<span id="L357" rel="#L357">357</span>
<span id="L358" rel="#L358">358</span>
<span id="L359" rel="#L359">359</span>
<span id="L360" rel="#L360">360</span>
<span id="L361" rel="#L361">361</span>
<span id="L362" rel="#L362">362</span>
<span id="L363" rel="#L363">363</span>
<span id="L364" rel="#L364">364</span>
<span id="L365" rel="#L365">365</span>
<span id="L366" rel="#L366">366</span>
<span id="L367" rel="#L367">367</span>
<span id="L368" rel="#L368">368</span>
<span id="L369" rel="#L369">369</span>
<span id="L370" rel="#L370">370</span>
<span id="L371" rel="#L371">371</span>
<span id="L372" rel="#L372">372</span>
<span id="L373" rel="#L373">373</span>
<span id="L374" rel="#L374">374</span>
<span id="L375" rel="#L375">375</span>
<span id="L376" rel="#L376">376</span>
<span id="L377" rel="#L377">377</span>
<span id="L378" rel="#L378">378</span>
<span id="L379" rel="#L379">379</span>
<span id="L380" rel="#L380">380</span>
<span id="L381" rel="#L381">381</span>
<span id="L382" rel="#L382">382</span>
<span id="L383" rel="#L383">383</span>
<span id="L384" rel="#L384">384</span>
<span id="L385" rel="#L385">385</span>
<span id="L386" rel="#L386">386</span>
<span id="L387" rel="#L387">387</span>
<span id="L388" rel="#L388">388</span>
<span id="L389" rel="#L389">389</span>
<span id="L390" rel="#L390">390</span>
<span id="L391" rel="#L391">391</span>
<span id="L392" rel="#L392">392</span>
<span id="L393" rel="#L393">393</span>
<span id="L394" rel="#L394">394</span>
<span id="L395" rel="#L395">395</span>
<span id="L396" rel="#L396">396</span>
<span id="L397" rel="#L397">397</span>
<span id="L398" rel="#L398">398</span>
<span id="L399" rel="#L399">399</span>
<span id="L400" rel="#L400">400</span>
<span id="L401" rel="#L401">401</span>
<span id="L402" rel="#L402">402</span>
<span id="L403" rel="#L403">403</span>
<span id="L404" rel="#L404">404</span>
<span id="L405" rel="#L405">405</span>
<span id="L406" rel="#L406">406</span>
<span id="L407" rel="#L407">407</span>
<span id="L408" rel="#L408">408</span>
<span id="L409" rel="#L409">409</span>
<span id="L410" rel="#L410">410</span>
<span id="L411" rel="#L411">411</span>
<span id="L412" rel="#L412">412</span>
<span id="L413" rel="#L413">413</span>
<span id="L414" rel="#L414">414</span>
<span id="L415" rel="#L415">415</span>
<span id="L416" rel="#L416">416</span>
<span id="L417" rel="#L417">417</span>
<span id="L418" rel="#L418">418</span>
<span id="L419" rel="#L419">419</span>
<span id="L420" rel="#L420">420</span>
<span id="L421" rel="#L421">421</span>
<span id="L422" rel="#L422">422</span>
<span id="L423" rel="#L423">423</span>
<span id="L424" rel="#L424">424</span>
<span id="L425" rel="#L425">425</span>
<span id="L426" rel="#L426">426</span>
<span id="L427" rel="#L427">427</span>
<span id="L428" rel="#L428">428</span>
<span id="L429" rel="#L429">429</span>
<span id="L430" rel="#L430">430</span>
<span id="L431" rel="#L431">431</span>
<span id="L432" rel="#L432">432</span>
<span id="L433" rel="#L433">433</span>
<span id="L434" rel="#L434">434</span>
<span id="L435" rel="#L435">435</span>
<span id="L436" rel="#L436">436</span>
<span id="L437" rel="#L437">437</span>
<span id="L438" rel="#L438">438</span>
<span id="L439" rel="#L439">439</span>
<span id="L440" rel="#L440">440</span>
<span id="L441" rel="#L441">441</span>
<span id="L442" rel="#L442">442</span>
<span id="L443" rel="#L443">443</span>
<span id="L444" rel="#L444">444</span>
<span id="L445" rel="#L445">445</span>
<span id="L446" rel="#L446">446</span>
<span id="L447" rel="#L447">447</span>
<span id="L448" rel="#L448">448</span>
<span id="L449" rel="#L449">449</span>
<span id="L450" rel="#L450">450</span>
<span id="L451" rel="#L451">451</span>
<span id="L452" rel="#L452">452</span>
<span id="L453" rel="#L453">453</span>
<span id="L454" rel="#L454">454</span>
<span id="L455" rel="#L455">455</span>
<span id="L456" rel="#L456">456</span>
<span id="L457" rel="#L457">457</span>
<span id="L458" rel="#L458">458</span>
<span id="L459" rel="#L459">459</span>
<span id="L460" rel="#L460">460</span>
<span id="L461" rel="#L461">461</span>
<span id="L462" rel="#L462">462</span>
<span id="L463" rel="#L463">463</span>
<span id="L464" rel="#L464">464</span>
<span id="L465" rel="#L465">465</span>
<span id="L466" rel="#L466">466</span>
<span id="L467" rel="#L467">467</span>
<span id="L468" rel="#L468">468</span>
<span id="L469" rel="#L469">469</span>
<span id="L470" rel="#L470">470</span>
<span id="L471" rel="#L471">471</span>
<span id="L472" rel="#L472">472</span>
<span id="L473" rel="#L473">473</span>
<span id="L474" rel="#L474">474</span>
<span id="L475" rel="#L475">475</span>
<span id="L476" rel="#L476">476</span>
<span id="L477" rel="#L477">477</span>
<span id="L478" rel="#L478">478</span>
<span id="L479" rel="#L479">479</span>
<span id="L480" rel="#L480">480</span>
<span id="L481" rel="#L481">481</span>
<span id="L482" rel="#L482">482</span>
<span id="L483" rel="#L483">483</span>
<span id="L484" rel="#L484">484</span>
<span id="L485" rel="#L485">485</span>
<span id="L486" rel="#L486">486</span>
<span id="L487" rel="#L487">487</span>
<span id="L488" rel="#L488">488</span>
<span id="L489" rel="#L489">489</span>
<span id="L490" rel="#L490">490</span>
<span id="L491" rel="#L491">491</span>
<span id="L492" rel="#L492">492</span>
<span id="L493" rel="#L493">493</span>
<span id="L494" rel="#L494">494</span>
<span id="L495" rel="#L495">495</span>
<span id="L496" rel="#L496">496</span>
<span id="L497" rel="#L497">497</span>
<span id="L498" rel="#L498">498</span>
<span id="L499" rel="#L499">499</span>
<span id="L500" rel="#L500">500</span>
<span id="L501" rel="#L501">501</span>
<span id="L502" rel="#L502">502</span>
<span id="L503" rel="#L503">503</span>
<span id="L504" rel="#L504">504</span>
<span id="L505" rel="#L505">505</span>
<span id="L506" rel="#L506">506</span>
<span id="L507" rel="#L507">507</span>
<span id="L508" rel="#L508">508</span>
<span id="L509" rel="#L509">509</span>
<span id="L510" rel="#L510">510</span>
<span id="L511" rel="#L511">511</span>
<span id="L512" rel="#L512">512</span>
<span id="L513" rel="#L513">513</span>
<span id="L514" rel="#L514">514</span>
<span id="L515" rel="#L515">515</span>
<span id="L516" rel="#L516">516</span>
<span id="L517" rel="#L517">517</span>
<span id="L518" rel="#L518">518</span>
<span id="L519" rel="#L519">519</span>
<span id="L520" rel="#L520">520</span>
<span id="L521" rel="#L521">521</span>
<span id="L522" rel="#L522">522</span>
<span id="L523" rel="#L523">523</span>
<span id="L524" rel="#L524">524</span>
<span id="L525" rel="#L525">525</span>
<span id="L526" rel="#L526">526</span>
<span id="L527" rel="#L527">527</span>
<span id="L528" rel="#L528">528</span>
<span id="L529" rel="#L529">529</span>
<span id="L530" rel="#L530">530</span>
<span id="L531" rel="#L531">531</span>
<span id="L532" rel="#L532">532</span>
<span id="L533" rel="#L533">533</span>
<span id="L534" rel="#L534">534</span>
<span id="L535" rel="#L535">535</span>
<span id="L536" rel="#L536">536</span>
<span id="L537" rel="#L537">537</span>
<span id="L538" rel="#L538">538</span>
<span id="L539" rel="#L539">539</span>
<span id="L540" rel="#L540">540</span>
<span id="L541" rel="#L541">541</span>
<span id="L542" rel="#L542">542</span>
<span id="L543" rel="#L543">543</span>
<span id="L544" rel="#L544">544</span>
<span id="L545" rel="#L545">545</span>
<span id="L546" rel="#L546">546</span>
<span id="L547" rel="#L547">547</span>
<span id="L548" rel="#L548">548</span>
<span id="L549" rel="#L549">549</span>
<span id="L550" rel="#L550">550</span>
<span id="L551" rel="#L551">551</span>
<span id="L552" rel="#L552">552</span>
<span id="L553" rel="#L553">553</span>
<span id="L554" rel="#L554">554</span>
<span id="L555" rel="#L555">555</span>
<span id="L556" rel="#L556">556</span>
<span id="L557" rel="#L557">557</span>
<span id="L558" rel="#L558">558</span>
<span id="L559" rel="#L559">559</span>
<span id="L560" rel="#L560">560</span>
<span id="L561" rel="#L561">561</span>
<span id="L562" rel="#L562">562</span>
<span id="L563" rel="#L563">563</span>

           </td>
           <td class="blob-line-code"><div class="code-body highlight"><pre><div class='line' id='LC1'><span class="cm">/*</span></div><div class='line' id='LC2'><span class="cm">selectivizr v1.0.3b - (c) Keith Clark, freely distributable under the terms </span></div><div class='line' id='LC3'><span class="cm">of the MIT license.</span></div><div class='line' id='LC4'><br/></div><div class='line' id='LC5'><span class="cm">selectivizr.com</span></div><div class='line' id='LC6'><span class="cm">*/</span></div><div class='line' id='LC7'><span class="cm">/* </span></div><div class='line' id='LC8'><span class="cm">  </span></div><div class='line' id='LC9'><span class="cm">Notes about this source</span></div><div class='line' id='LC10'><span class="cm">-----------------------</span></div><div class='line' id='LC11'><br/></div><div class='line' id='LC12'><span class="cm"> * The #DEBUG_START and #DEBUG_END comments are used to mark blocks of code</span></div><div class='line' id='LC13'><span class="cm">   that will be removed prior to building a final release version (using a</span></div><div class='line' id='LC14'><span class="cm">   pre-compression script)</span></div><div class='line' id='LC15'><span class="cm">  </span></div><div class='line' id='LC16'><span class="cm">  </span></div><div class='line' id='LC17'><span class="cm">References:</span></div><div class='line' id='LC18'><span class="cm">-----------</span></div><div class='line' id='LC19'><span class="cm"> </span></div><div class='line' id='LC20'><span class="cm"> * CSS Syntax          : http://www.w3.org/TR/2003/WD-css3-syntax-20030813/#style</span></div><div class='line' id='LC21'><span class="cm"> * Selectors           : http://www.w3.org/TR/css3-selectors/#selectors</span></div><div class='line' id='LC22'><span class="cm"> * IE Compatability    : http://msdn.microsoft.com/en-us/library/cc351024(VS.85).aspx</span></div><div class='line' id='LC23'><span class="cm"> * W3C Selector Tests  : http://www.w3.org/Style/CSS/Test/CSS3/Selectors/current/html/tests/</span></div><div class='line' id='LC24'><span class="cm"> </span></div><div class='line' id='LC25'><span class="cm">*/</span></div><div class='line' id='LC26'><br/></div><div class='line' id='LC27'><span class="p">(</span><span class="kd">function</span><span class="p">(</span><span class="nx">win</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC28'><br/></div><div class='line' id='LC29'>	<span class="c1">// Determine IE version and stop execution if browser isn&#39;t IE. This</span></div><div class='line' id='LC30'>	<span class="c1">// handles the script being loaded by non IE browsers because the</span></div><div class='line' id='LC31'>	<span class="c1">// developer didn&#39;t use conditional comments.</span></div><div class='line' id='LC32'>	<span class="kd">var</span> <span class="nx">ieUserAgent</span> <span class="o">=</span> <span class="nx">navigator</span><span class="p">.</span><span class="nx">userAgent</span><span class="p">.</span><span class="nx">match</span><span class="p">(</span><span class="sr">/MSIE (\d+)/</span><span class="p">);</span></div><div class='line' id='LC33'>	<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">ieUserAgent</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC34'>		<span class="k">return</span> <span class="kc">false</span><span class="p">;</span></div><div class='line' id='LC35'>	<span class="p">}</span></div><div class='line' id='LC36'><br/></div><div class='line' id='LC37'>	<span class="c1">// =========================== Init Objects ============================</span></div><div class='line' id='LC38'><br/></div><div class='line' id='LC39'>	<span class="kd">var</span> <span class="nx">doc</span> <span class="o">=</span> <span class="nb">document</span><span class="p">;</span></div><div class='line' id='LC40'>	<span class="kd">var</span> <span class="nx">root</span> <span class="o">=</span> <span class="nx">doc</span><span class="p">.</span><span class="nx">documentElement</span><span class="p">;</span></div><div class='line' id='LC41'>	<span class="kd">var</span> <span class="nx">xhr</span> <span class="o">=</span> <span class="nx">getXHRObject</span><span class="p">();</span></div><div class='line' id='LC42'>	<span class="kd">var</span> <span class="nx">ieVersion</span> <span class="o">=</span> <span class="nx">ieUserAgent</span><span class="p">[</span><span class="mi">1</span><span class="p">];</span></div><div class='line' id='LC43'><br/></div><div class='line' id='LC44'>	<span class="c1">// If were not in standards mode, IE is too old / new or we can&#39;t create</span></div><div class='line' id='LC45'>	<span class="c1">// an XMLHttpRequest object then we should get out now.</span></div><div class='line' id='LC46'>	<span class="k">if</span> <span class="p">(</span><span class="nx">doc</span><span class="p">.</span><span class="nx">compatMode</span> <span class="o">!=</span> <span class="s1">&#39;CSS1Compat&#39;</span> <span class="o">||</span> <span class="nx">ieVersion</span><span class="o">&lt;</span><span class="mi">6</span> <span class="o">||</span> <span class="nx">ieVersion</span><span class="o">&gt;</span><span class="mi">8</span> <span class="o">||</span> <span class="o">!</span><span class="nx">xhr</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC47'>		<span class="k">return</span><span class="p">;</span></div><div class='line' id='LC48'>	<span class="p">}</span></div><div class='line' id='LC49'><br/></div><div class='line' id='LC50'><br/></div><div class='line' id='LC51'>	<span class="c1">// ========================= Common Objects ============================</span></div><div class='line' id='LC52'><br/></div><div class='line' id='LC53'>	<span class="c1">// Compatiable selector engines in order of CSS3 support. Note: &#39;*&#39; is</span></div><div class='line' id='LC54'>	<span class="c1">// a placholder for the object key name. (basically, crude compression)</span></div><div class='line' id='LC55'>	<span class="kd">var</span> <span class="nx">selectorEngines</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC56'>		<span class="s2">&quot;NW&quot;</span>								<span class="o">:</span> <span class="s2">&quot;*.Dom.select&quot;</span><span class="p">,</span></div><div class='line' id='LC57'>		<span class="s2">&quot;MooTools&quot;</span>							<span class="o">:</span> <span class="s2">&quot;$$&quot;</span><span class="p">,</span></div><div class='line' id='LC58'>		<span class="s2">&quot;DOMAssistant&quot;</span>						<span class="o">:</span> <span class="s2">&quot;*.$&quot;</span><span class="p">,</span> </div><div class='line' id='LC59'>		<span class="s2">&quot;Prototype&quot;</span>							<span class="o">:</span> <span class="s2">&quot;$$&quot;</span><span class="p">,</span></div><div class='line' id='LC60'>		<span class="s2">&quot;YAHOO&quot;</span>								<span class="o">:</span> <span class="s2">&quot;*.util.Selector.query&quot;</span><span class="p">,</span></div><div class='line' id='LC61'>		<span class="s2">&quot;Sizzle&quot;</span>							<span class="o">:</span> <span class="s2">&quot;*&quot;</span><span class="p">,</span> </div><div class='line' id='LC62'>		<span class="s2">&quot;jQuery&quot;</span>							<span class="o">:</span> <span class="s2">&quot;*&quot;</span><span class="p">,</span></div><div class='line' id='LC63'>		<span class="s2">&quot;dojo&quot;</span>								<span class="o">:</span> <span class="s2">&quot;*.query&quot;</span></div><div class='line' id='LC64'>	<span class="p">};</span></div><div class='line' id='LC65'><br/></div><div class='line' id='LC66'>	<span class="kd">var</span> <span class="nx">selectorMethod</span><span class="p">;</span></div><div class='line' id='LC67'>	<span class="kd">var</span> <span class="nx">enabledWatchers</span> 					<span class="o">=</span> <span class="p">[];</span>     <span class="c1">// array of :enabled/:disabled elements to poll</span></div><div class='line' id='LC68'>	<span class="kd">var</span> <span class="nx">domPatches</span>							<span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC69'>	<span class="kd">var</span> <span class="nx">ie6PatchID</span> 							<span class="o">=</span> <span class="mi">0</span><span class="p">;</span>      <span class="c1">// used to solve ie6&#39;s multiple class bug</span></div><div class='line' id='LC70'>	<span class="kd">var</span> <span class="nx">patchIE6MultipleClasses</span>				<span class="o">=</span> <span class="kc">true</span><span class="p">;</span>   <span class="c1">// if true adds class bloat to ie6</span></div><div class='line' id='LC71'>	<span class="kd">var</span> <span class="nx">namespace</span> 							<span class="o">=</span> <span class="s2">&quot;slvzr&quot;</span><span class="p">;</span></div><div class='line' id='LC72'><br/></div><div class='line' id='LC73'>	<span class="c1">// Stylesheet parsing regexp&#39;s</span></div><div class='line' id='LC74'>	<span class="kd">var</span> <span class="nx">RE_COMMENT</span>							<span class="o">=</span> <span class="sr">/(\/\*[^*]*\*+([^\/][^*]*\*+)*\/)\s*?/g</span><span class="p">;</span></div><div class='line' id='LC75'>	<span class="kd">var</span> <span class="nx">RE_IMPORT</span>							<span class="o">=</span> <span class="sr">/@import\s*(?:(?:(?:url\(\s*([&#39;&quot;]?)(.*)\1)\s*\))|(?:([&#39;&quot;])(.*)\3))\s*([^;]*);/g</span><span class="p">;</span></div><div class='line' id='LC76'>	<span class="kd">var</span> <span class="nx">RE_ASSET_URL</span> 						<span class="o">=</span> <span class="sr">/(behavior\s*?:\s*)?\burl\(\s*([&quot;&#39;]?)(?!data:)([^&quot;&#39;)]+)\2\s*\)/g</span><span class="p">;</span></div><div class='line' id='LC77'>	<span class="kd">var</span> <span class="nx">RE_PSEUDO_STRUCTURAL</span>				<span class="o">=</span> <span class="sr">/^:(empty|(first|last|only|nth(-last)?)-(child|of-type))$/</span><span class="p">;</span></div><div class='line' id='LC78'>	<span class="kd">var</span> <span class="nx">RE_PSEUDO_ELEMENTS</span>					<span class="o">=</span> <span class="sr">/:(:first-(?:line|letter))/g</span><span class="p">;</span></div><div class='line' id='LC79'>	<span class="kd">var</span> <span class="nx">RE_SELECTOR_GROUP</span>					<span class="o">=</span> <span class="sr">/((?:^|(?:\s*})+)(?:\s*@media[^{]+{)?)\s*([^\{]*?[\[:][^{]+)/g</span><span class="p">;</span></div><div class='line' id='LC80'>	<span class="kd">var</span> <span class="nx">RE_SELECTOR_PARSE</span>					<span class="o">=</span> <span class="sr">/([ +~&gt;])|(:[a-z-]+(?:\(.*?\)+)?)|(\[.*?\])/g</span><span class="p">;</span> </div><div class='line' id='LC81'>	<span class="kd">var</span> <span class="nx">RE_LIBRARY_INCOMPATIBLE_PSEUDOS</span>		<span class="o">=</span> <span class="sr">/(:not\()?:(hover|enabled|disabled|focus|checked|target|active|visited|first-line|first-letter)\)?/g</span><span class="p">;</span></div><div class='line' id='LC82'>	<span class="kd">var</span> <span class="nx">RE_PATCH_CLASS_NAME_REPLACE</span>			<span class="o">=</span> <span class="sr">/[^\w-]/g</span><span class="p">;</span></div><div class='line' id='LC83'><br/></div><div class='line' id='LC84'>	<span class="c1">// HTML UI element regexp&#39;s</span></div><div class='line' id='LC85'>	<span class="kd">var</span> <span class="nx">RE_INPUT_ELEMENTS</span>					<span class="o">=</span> <span class="sr">/^(INPUT|SELECT|TEXTAREA|BUTTON)$/</span><span class="p">;</span></div><div class='line' id='LC86'>	<span class="kd">var</span> <span class="nx">RE_INPUT_CHECKABLE_TYPES</span>			<span class="o">=</span> <span class="sr">/^(checkbox|radio)$/</span><span class="p">;</span></div><div class='line' id='LC87'><br/></div><div class='line' id='LC88'>	<span class="c1">// Broken attribute selector implementations (IE7/8 native [^=&quot;&quot;], [$=&quot;&quot;] and [*=&quot;&quot;])</span></div><div class='line' id='LC89'>	<span class="kd">var</span> <span class="nx">BROKEN_ATTR_IMPLEMENTATIONS</span>			<span class="o">=</span> <span class="nx">ieVersion</span><span class="o">&gt;</span><span class="mi">6</span> <span class="o">?</span> <span class="sr">/[\$\^*]=([&#39;&quot;])\1/</span> <span class="o">:</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC90'><br/></div><div class='line' id='LC91'>	<span class="c1">// Whitespace normalization regexp&#39;s</span></div><div class='line' id='LC92'>	<span class="kd">var</span> <span class="nx">RE_TIDY_TRAILING_WHITESPACE</span>			<span class="o">=</span> <span class="sr">/([(\[+~])\s+/g</span><span class="p">;</span></div><div class='line' id='LC93'>	<span class="kd">var</span> <span class="nx">RE_TIDY_LEADING_WHITESPACE</span>			<span class="o">=</span> <span class="sr">/\s+([)\]+~])/g</span><span class="p">;</span></div><div class='line' id='LC94'>	<span class="kd">var</span> <span class="nx">RE_TIDY_CONSECUTIVE_WHITESPACE</span>		<span class="o">=</span> <span class="sr">/\s+/g</span><span class="p">;</span></div><div class='line' id='LC95'>	<span class="kd">var</span> <span class="nx">RE_TIDY_TRIM_WHITESPACE</span>				<span class="o">=</span> <span class="sr">/^\s*((?:[\S\s]*\S)?)\s*$/</span><span class="p">;</span></div><div class='line' id='LC96'><br/></div><div class='line' id='LC97'>	<span class="c1">// String constants</span></div><div class='line' id='LC98'>	<span class="kd">var</span> <span class="nx">EMPTY_STRING</span>						<span class="o">=</span> <span class="s2">&quot;&quot;</span><span class="p">;</span></div><div class='line' id='LC99'>	<span class="kd">var</span> <span class="nx">SPACE_STRING</span>						<span class="o">=</span> <span class="s2">&quot; &quot;</span><span class="p">;</span></div><div class='line' id='LC100'>	<span class="kd">var</span> <span class="nx">PLACEHOLDER_STRING</span>					<span class="o">=</span> <span class="s2">&quot;$1&quot;</span><span class="p">;</span></div><div class='line' id='LC101'><br/></div><div class='line' id='LC102'>	<span class="c1">// =========================== Patching ================================</span></div><div class='line' id='LC103'><br/></div><div class='line' id='LC104'>	<span class="c1">// --[ patchStyleSheet() ]----------------------------------------------</span></div><div class='line' id='LC105'>	<span class="c1">// Scans the passed cssText for selectors that require emulation and</span></div><div class='line' id='LC106'>	<span class="c1">// creates one or more patches for each matched selector.</span></div><div class='line' id='LC107'>	<span class="kd">function</span> <span class="nx">patchStyleSheet</span><span class="p">(</span> <span class="nx">cssText</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC108'>		<span class="k">return</span> <span class="nx">cssText</span><span class="p">.</span><span class="nx">replace</span><span class="p">(</span><span class="nx">RE_PSEUDO_ELEMENTS</span><span class="p">,</span> <span class="nx">PLACEHOLDER_STRING</span><span class="p">).</span></div><div class='line' id='LC109'>			<span class="nx">replace</span><span class="p">(</span><span class="nx">RE_SELECTOR_GROUP</span><span class="p">,</span> <span class="kd">function</span><span class="p">(</span><span class="nx">m</span><span class="p">,</span> <span class="nx">prefix</span><span class="p">,</span> <span class="nx">selectorText</span><span class="p">)</span> <span class="p">{</span>	</div><div class='line' id='LC110'>&nbsp;&nbsp;&nbsp;&nbsp;			<span class="kd">var</span> <span class="nx">selectorGroups</span> <span class="o">=</span> <span class="nx">selectorText</span><span class="p">.</span><span class="nx">split</span><span class="p">(</span><span class="s2">&quot;,&quot;</span><span class="p">);</span></div><div class='line' id='LC111'>&nbsp;&nbsp;&nbsp;&nbsp;			<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">c</span> <span class="o">=</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">cs</span> <span class="o">=</span> <span class="nx">selectorGroups</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">c</span> <span class="o">&lt;</span> <span class="nx">cs</span><span class="p">;</span> <span class="nx">c</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC112'>&nbsp;&nbsp;&nbsp;&nbsp;				<span class="kd">var</span> <span class="nx">selector</span> <span class="o">=</span> <span class="nx">normalizeSelectorWhitespace</span><span class="p">(</span><span class="nx">selectorGroups</span><span class="p">[</span><span class="nx">c</span><span class="p">])</span> <span class="o">+</span> <span class="nx">SPACE_STRING</span><span class="p">;</span></div><div class='line' id='LC113'>&nbsp;&nbsp;&nbsp;&nbsp;				<span class="kd">var</span> <span class="nx">patches</span> <span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC114'>&nbsp;&nbsp;&nbsp;&nbsp;				<span class="nx">selectorGroups</span><span class="p">[</span><span class="nx">c</span><span class="p">]</span> <span class="o">=</span> <span class="nx">selector</span><span class="p">.</span><span class="nx">replace</span><span class="p">(</span><span class="nx">RE_SELECTOR_PARSE</span><span class="p">,</span> </div><div class='line' id='LC115'>&nbsp;&nbsp;&nbsp;&nbsp;					<span class="kd">function</span><span class="p">(</span><span class="nx">match</span><span class="p">,</span> <span class="nx">combinator</span><span class="p">,</span> <span class="nx">pseudo</span><span class="p">,</span> <span class="nx">attribute</span><span class="p">,</span> <span class="nx">index</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC116'>&nbsp;&nbsp;&nbsp;&nbsp;						<span class="k">if</span> <span class="p">(</span><span class="nx">combinator</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC117'>&nbsp;&nbsp;&nbsp;&nbsp;							<span class="k">if</span> <span class="p">(</span><span class="nx">patches</span><span class="p">.</span><span class="nx">length</span><span class="o">&gt;</span><span class="mi">0</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC118'>&nbsp;&nbsp;&nbsp;&nbsp;								<span class="nx">domPatches</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span> <span class="p">{</span> <span class="nx">selector</span><span class="o">:</span> <span class="nx">selector</span><span class="p">.</span><span class="nx">substring</span><span class="p">(</span><span class="mi">0</span><span class="p">,</span> <span class="nx">index</span><span class="p">),</span> <span class="nx">patches</span><span class="o">:</span> <span class="nx">patches</span> <span class="p">}</span> <span class="p">)</span></div><div class='line' id='LC119'>&nbsp;&nbsp;&nbsp;&nbsp;								<span class="nx">patches</span> <span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC120'>&nbsp;&nbsp;&nbsp;&nbsp;							<span class="p">}</span></div><div class='line' id='LC121'>&nbsp;&nbsp;&nbsp;&nbsp;							<span class="k">return</span> <span class="nx">combinator</span><span class="p">;</span></div><div class='line' id='LC122'>&nbsp;&nbsp;&nbsp;&nbsp;						<span class="p">}</span>		</div><div class='line' id='LC123'>&nbsp;&nbsp;&nbsp;&nbsp;						<span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC124'>&nbsp;&nbsp;&nbsp;&nbsp;							<span class="kd">var</span> <span class="nx">patch</span> <span class="o">=</span> <span class="p">(</span><span class="nx">pseudo</span><span class="p">)</span> <span class="o">?</span> <span class="nx">patchPseudoClass</span><span class="p">(</span> <span class="nx">pseudo</span> <span class="p">)</span> <span class="o">:</span> <span class="nx">patchAttribute</span><span class="p">(</span> <span class="nx">attribute</span> <span class="p">);</span></div><div class='line' id='LC125'>&nbsp;&nbsp;&nbsp;&nbsp;							<span class="k">if</span> <span class="p">(</span><span class="nx">patch</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC126'>&nbsp;&nbsp;&nbsp;&nbsp;								<span class="nx">patches</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="nx">patch</span><span class="p">);</span></div><div class='line' id='LC127'>&nbsp;&nbsp;&nbsp;&nbsp;								<span class="k">return</span> <span class="s2">&quot;.&quot;</span> <span class="o">+</span> <span class="nx">patch</span><span class="p">.</span><span class="nx">className</span><span class="p">;</span></div><div class='line' id='LC128'>&nbsp;&nbsp;&nbsp;&nbsp;							<span class="p">}</span></div><div class='line' id='LC129'>&nbsp;&nbsp;&nbsp;&nbsp;							<span class="k">return</span> <span class="nx">match</span><span class="p">;</span></div><div class='line' id='LC130'>&nbsp;&nbsp;&nbsp;&nbsp;						<span class="p">}</span></div><div class='line' id='LC131'>&nbsp;&nbsp;&nbsp;&nbsp;					<span class="p">}</span></div><div class='line' id='LC132'>&nbsp;&nbsp;&nbsp;&nbsp;				<span class="p">);</span></div><div class='line' id='LC133'>&nbsp;&nbsp;&nbsp;&nbsp;			<span class="p">}</span></div><div class='line' id='LC134'>&nbsp;&nbsp;&nbsp;&nbsp;			<span class="k">return</span> <span class="nx">prefix</span> <span class="o">+</span> <span class="nx">selectorGroups</span><span class="p">.</span><span class="nx">join</span><span class="p">(</span><span class="s2">&quot;,&quot;</span><span class="p">);</span></div><div class='line' id='LC135'>&nbsp;&nbsp;&nbsp;&nbsp;		<span class="p">});</span></div><div class='line' id='LC136'>	<span class="p">};</span></div><div class='line' id='LC137'><br/></div><div class='line' id='LC138'>	<span class="c1">// --[ patchAttribute() ]-----------------------------------------------</span></div><div class='line' id='LC139'>	<span class="c1">// returns a patch for an attribute selector.</span></div><div class='line' id='LC140'>	<span class="kd">function</span> <span class="nx">patchAttribute</span><span class="p">(</span> <span class="nx">attr</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC141'>		<span class="k">return</span> <span class="p">(</span><span class="o">!</span><span class="nx">BROKEN_ATTR_IMPLEMENTATIONS</span> <span class="o">||</span> <span class="nx">BROKEN_ATTR_IMPLEMENTATIONS</span><span class="p">.</span><span class="nx">test</span><span class="p">(</span><span class="nx">attr</span><span class="p">))</span> <span class="o">?</span> </div><div class='line' id='LC142'>			<span class="p">{</span> <span class="nx">className</span><span class="o">:</span> <span class="nx">createClassName</span><span class="p">(</span><span class="nx">attr</span><span class="p">),</span> <span class="nx">applyClass</span><span class="o">:</span> <span class="kc">true</span> <span class="p">}</span> <span class="o">:</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC143'>	<span class="p">};</span></div><div class='line' id='LC144'><br/></div><div class='line' id='LC145'>	<span class="c1">// --[ patchPseudoClass() ]---------------------------------------------</span></div><div class='line' id='LC146'>	<span class="c1">// returns a patch for a pseudo-class</span></div><div class='line' id='LC147'>	<span class="kd">function</span> <span class="nx">patchPseudoClass</span><span class="p">(</span> <span class="nx">pseudo</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC148'><br/></div><div class='line' id='LC149'>		<span class="kd">var</span> <span class="nx">applyClass</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC150'>		<span class="kd">var</span> <span class="nx">className</span> <span class="o">=</span> <span class="nx">createClassName</span><span class="p">(</span><span class="nx">pseudo</span><span class="p">.</span><span class="nx">slice</span><span class="p">(</span><span class="mi">1</span><span class="p">));</span></div><div class='line' id='LC151'>		<span class="kd">var</span> <span class="nx">isNegated</span> <span class="o">=</span> <span class="nx">pseudo</span><span class="p">.</span><span class="nx">substring</span><span class="p">(</span><span class="mi">0</span><span class="p">,</span> <span class="mi">5</span><span class="p">)</span> <span class="o">==</span> <span class="s2">&quot;:not(&quot;</span><span class="p">;</span></div><div class='line' id='LC152'>		<span class="kd">var</span> <span class="nx">activateEventName</span><span class="p">;</span></div><div class='line' id='LC153'>		<span class="kd">var</span> <span class="nx">deactivateEventName</span><span class="p">;</span></div><div class='line' id='LC154'><br/></div><div class='line' id='LC155'>		<span class="c1">// if negated, remove :not() </span></div><div class='line' id='LC156'>		<span class="k">if</span> <span class="p">(</span><span class="nx">isNegated</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC157'>			<span class="nx">pseudo</span> <span class="o">=</span> <span class="nx">pseudo</span><span class="p">.</span><span class="nx">slice</span><span class="p">(</span><span class="mi">5</span><span class="p">,</span> <span class="o">-</span><span class="mi">1</span><span class="p">);</span></div><div class='line' id='LC158'>		<span class="p">}</span></div><div class='line' id='LC159'><br/></div><div class='line' id='LC160'>		<span class="c1">// bracket contents are irrelevant - remove them</span></div><div class='line' id='LC161'>		<span class="kd">var</span> <span class="nx">bracketIndex</span> <span class="o">=</span> <span class="nx">pseudo</span><span class="p">.</span><span class="nx">indexOf</span><span class="p">(</span><span class="s2">&quot;(&quot;</span><span class="p">)</span></div><div class='line' id='LC162'>		<span class="k">if</span> <span class="p">(</span><span class="nx">bracketIndex</span> <span class="o">&gt;</span> <span class="o">-</span><span class="mi">1</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC163'>			<span class="nx">pseudo</span> <span class="o">=</span> <span class="nx">pseudo</span><span class="p">.</span><span class="nx">substring</span><span class="p">(</span><span class="mi">0</span><span class="p">,</span> <span class="nx">bracketIndex</span><span class="p">);</span></div><div class='line' id='LC164'>		<span class="p">}</span>		</div><div class='line' id='LC165'><br/></div><div class='line' id='LC166'>		<span class="c1">// check we&#39;re still dealing with a pseudo-class</span></div><div class='line' id='LC167'>		<span class="k">if</span> <span class="p">(</span><span class="nx">pseudo</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="mi">0</span><span class="p">)</span> <span class="o">==</span> <span class="s2">&quot;:&quot;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC168'>			<span class="k">switch</span> <span class="p">(</span><span class="nx">pseudo</span><span class="p">.</span><span class="nx">slice</span><span class="p">(</span><span class="mi">1</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC169'><br/></div><div class='line' id='LC170'>				<span class="k">case</span> <span class="s2">&quot;root&quot;</span><span class="o">:</span></div><div class='line' id='LC171'>					<span class="nx">applyClass</span> <span class="o">=</span> <span class="kd">function</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC172'>						<span class="k">return</span> <span class="nx">isNegated</span> <span class="o">?</span> <span class="nx">e</span> <span class="o">!=</span> <span class="nx">root</span> <span class="o">:</span> <span class="nx">e</span> <span class="o">==</span> <span class="nx">root</span><span class="p">;</span></div><div class='line' id='LC173'>					<span class="p">}</span></div><div class='line' id='LC174'>					<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC175'><br/></div><div class='line' id='LC176'>				<span class="k">case</span> <span class="s2">&quot;target&quot;</span><span class="o">:</span></div><div class='line' id='LC177'>					<span class="c1">// :target is only supported in IE8</span></div><div class='line' id='LC178'>					<span class="k">if</span> <span class="p">(</span><span class="nx">ieVersion</span> <span class="o">==</span> <span class="mi">8</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC179'>						<span class="nx">applyClass</span> <span class="o">=</span> <span class="kd">function</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC180'>							<span class="kd">var</span> <span class="nx">handler</span> <span class="o">=</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span> </div><div class='line' id='LC181'>								<span class="kd">var</span> <span class="nx">hash</span> <span class="o">=</span> <span class="nx">location</span><span class="p">.</span><span class="nx">hash</span><span class="p">;</span></div><div class='line' id='LC182'>								<span class="kd">var</span> <span class="nx">hashID</span> <span class="o">=</span> <span class="nx">hash</span><span class="p">.</span><span class="nx">slice</span><span class="p">(</span><span class="mi">1</span><span class="p">);</span></div><div class='line' id='LC183'>								<span class="k">return</span> <span class="nx">isNegated</span> <span class="o">?</span> <span class="p">(</span><span class="nx">hash</span> <span class="o">==</span> <span class="nx">EMPTY_STRING</span> <span class="o">||</span> <span class="nx">e</span><span class="p">.</span><span class="nx">id</span> <span class="o">!=</span> <span class="nx">hashID</span><span class="p">)</span> <span class="o">:</span> <span class="p">(</span><span class="nx">hash</span> <span class="o">!=</span> <span class="nx">EMPTY_STRING</span> <span class="o">&amp;&amp;</span> <span class="nx">e</span><span class="p">.</span><span class="nx">id</span> <span class="o">==</span> <span class="nx">hashID</span><span class="p">);</span></div><div class='line' id='LC184'>							<span class="p">};</span></div><div class='line' id='LC185'>							<span class="nx">addEvent</span><span class="p">(</span> <span class="nx">win</span><span class="p">,</span> <span class="s2">&quot;hashchange&quot;</span><span class="p">,</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC186'>								<span class="nx">toggleElementClass</span><span class="p">(</span><span class="nx">e</span><span class="p">,</span> <span class="nx">className</span><span class="p">,</span> <span class="nx">handler</span><span class="p">());</span></div><div class='line' id='LC187'>							<span class="p">})</span></div><div class='line' id='LC188'>							<span class="k">return</span> <span class="nx">handler</span><span class="p">();</span></div><div class='line' id='LC189'>						<span class="p">}</span></div><div class='line' id='LC190'>						<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC191'>					<span class="p">}</span></div><div class='line' id='LC192'>					<span class="k">return</span> <span class="kc">false</span><span class="p">;</span></div><div class='line' id='LC193'><br/></div><div class='line' id='LC194'>				<span class="k">case</span> <span class="s2">&quot;checked&quot;</span><span class="o">:</span></div><div class='line' id='LC195'>					<span class="nx">applyClass</span> <span class="o">=</span> <span class="kd">function</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span> </div><div class='line' id='LC196'>						<span class="k">if</span> <span class="p">(</span><span class="nx">RE_INPUT_CHECKABLE_TYPES</span><span class="p">.</span><span class="nx">test</span><span class="p">(</span><span class="nx">e</span><span class="p">.</span><span class="nx">type</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC197'>							<span class="nx">addEvent</span><span class="p">(</span> <span class="nx">e</span><span class="p">,</span> <span class="s2">&quot;propertychange&quot;</span><span class="p">,</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC198'>								<span class="k">if</span> <span class="p">(</span><span class="nx">event</span><span class="p">.</span><span class="nx">propertyName</span> <span class="o">==</span> <span class="s2">&quot;checked&quot;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC199'>									<span class="nx">toggleElementClass</span><span class="p">(</span> <span class="nx">e</span><span class="p">,</span> <span class="nx">className</span><span class="p">,</span> <span class="nx">e</span><span class="p">.</span><span class="nx">checked</span> <span class="o">!==</span> <span class="nx">isNegated</span> <span class="p">);</span></div><div class='line' id='LC200'>								<span class="p">}</span> 							</div><div class='line' id='LC201'>							<span class="p">})</span></div><div class='line' id='LC202'>						<span class="p">}</span></div><div class='line' id='LC203'>						<span class="k">return</span> <span class="nx">e</span><span class="p">.</span><span class="nx">checked</span> <span class="o">!==</span> <span class="nx">isNegated</span><span class="p">;</span></div><div class='line' id='LC204'>					<span class="p">}</span></div><div class='line' id='LC205'>					<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC206'><br/></div><div class='line' id='LC207'>				<span class="k">case</span> <span class="s2">&quot;disabled&quot;</span><span class="o">:</span></div><div class='line' id='LC208'>					<span class="nx">isNegated</span> <span class="o">=</span> <span class="o">!</span><span class="nx">isNegated</span><span class="p">;</span></div><div class='line' id='LC209'><br/></div><div class='line' id='LC210'>				<span class="k">case</span> <span class="s2">&quot;enabled&quot;</span><span class="o">:</span></div><div class='line' id='LC211'>					<span class="nx">applyClass</span> <span class="o">=</span> <span class="kd">function</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span> </div><div class='line' id='LC212'>						<span class="k">if</span> <span class="p">(</span><span class="nx">RE_INPUT_ELEMENTS</span><span class="p">.</span><span class="nx">test</span><span class="p">(</span><span class="nx">e</span><span class="p">.</span><span class="nx">tagName</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC213'>							<span class="nx">addEvent</span><span class="p">(</span> <span class="nx">e</span><span class="p">,</span> <span class="s2">&quot;propertychange&quot;</span><span class="p">,</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC214'>								<span class="k">if</span> <span class="p">(</span><span class="nx">event</span><span class="p">.</span><span class="nx">propertyName</span> <span class="o">==</span> <span class="s2">&quot;$disabled&quot;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC215'>									<span class="nx">toggleElementClass</span><span class="p">(</span> <span class="nx">e</span><span class="p">,</span> <span class="nx">className</span><span class="p">,</span> <span class="nx">e</span><span class="p">.</span><span class="nx">$disabled</span> <span class="o">===</span> <span class="nx">isNegated</span> <span class="p">);</span></div><div class='line' id='LC216'>								<span class="p">}</span> </div><div class='line' id='LC217'>							<span class="p">});</span></div><div class='line' id='LC218'>							<span class="nx">enabledWatchers</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span><span class="nx">e</span><span class="p">);</span></div><div class='line' id='LC219'>							<span class="nx">e</span><span class="p">.</span><span class="nx">$disabled</span> <span class="o">=</span> <span class="nx">e</span><span class="p">.</span><span class="nx">disabled</span><span class="p">;</span></div><div class='line' id='LC220'>							<span class="k">return</span> <span class="nx">e</span><span class="p">.</span><span class="nx">disabled</span> <span class="o">===</span> <span class="nx">isNegated</span><span class="p">;</span></div><div class='line' id='LC221'>						<span class="p">}</span></div><div class='line' id='LC222'>						<span class="k">return</span> <span class="nx">pseudo</span> <span class="o">==</span> <span class="s2">&quot;:enabled&quot;</span> <span class="o">?</span> <span class="nx">isNegated</span> <span class="o">:</span> <span class="o">!</span><span class="nx">isNegated</span><span class="p">;</span></div><div class='line' id='LC223'>					<span class="p">}</span></div><div class='line' id='LC224'>					<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC225'><br/></div><div class='line' id='LC226'>				<span class="k">case</span> <span class="s2">&quot;focus&quot;</span><span class="o">:</span></div><div class='line' id='LC227'>					<span class="nx">activateEventName</span> <span class="o">=</span> <span class="s2">&quot;focus&quot;</span><span class="p">;</span></div><div class='line' id='LC228'>					<span class="nx">deactivateEventName</span> <span class="o">=</span> <span class="s2">&quot;blur&quot;</span><span class="p">;</span></div><div class='line' id='LC229'><br/></div><div class='line' id='LC230'>				<span class="k">case</span> <span class="s2">&quot;hover&quot;</span><span class="o">:</span></div><div class='line' id='LC231'>					<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">activateEventName</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC232'>						<span class="nx">activateEventName</span> <span class="o">=</span> <span class="s2">&quot;mouseenter&quot;</span><span class="p">;</span></div><div class='line' id='LC233'>						<span class="nx">deactivateEventName</span> <span class="o">=</span> <span class="s2">&quot;mouseleave&quot;</span><span class="p">;</span></div><div class='line' id='LC234'>					<span class="p">}</span></div><div class='line' id='LC235'>					<span class="nx">applyClass</span> <span class="o">=</span> <span class="kd">function</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC236'>						<span class="nx">addEvent</span><span class="p">(</span> <span class="nx">e</span><span class="p">,</span> <span class="nx">isNegated</span> <span class="o">?</span> <span class="nx">deactivateEventName</span> <span class="o">:</span> <span class="nx">activateEventName</span><span class="p">,</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC237'>							<span class="nx">toggleElementClass</span><span class="p">(</span> <span class="nx">e</span><span class="p">,</span> <span class="nx">className</span><span class="p">,</span> <span class="kc">true</span> <span class="p">);</span></div><div class='line' id='LC238'>						<span class="p">})</span></div><div class='line' id='LC239'>						<span class="nx">addEvent</span><span class="p">(</span> <span class="nx">e</span><span class="p">,</span> <span class="nx">isNegated</span> <span class="o">?</span> <span class="nx">activateEventName</span> <span class="o">:</span> <span class="nx">deactivateEventName</span><span class="p">,</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC240'>							<span class="nx">toggleElementClass</span><span class="p">(</span> <span class="nx">e</span><span class="p">,</span> <span class="nx">className</span><span class="p">,</span> <span class="kc">false</span> <span class="p">);</span></div><div class='line' id='LC241'>						<span class="p">})</span></div><div class='line' id='LC242'>						<span class="k">return</span> <span class="nx">isNegated</span><span class="p">;</span></div><div class='line' id='LC243'>					<span class="p">}</span></div><div class='line' id='LC244'>					<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC245'><br/></div><div class='line' id='LC246'>				<span class="c1">// everything else</span></div><div class='line' id='LC247'>				<span class="k">default</span><span class="o">:</span></div><div class='line' id='LC248'>					<span class="c1">// If we don&#39;t support this pseudo-class don&#39;t create </span></div><div class='line' id='LC249'>					<span class="c1">// a patch for it</span></div><div class='line' id='LC250'>					<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">RE_PSEUDO_STRUCTURAL</span><span class="p">.</span><span class="nx">test</span><span class="p">(</span><span class="nx">pseudo</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC251'>						<span class="k">return</span> <span class="kc">false</span><span class="p">;</span></div><div class='line' id='LC252'>					<span class="p">}</span></div><div class='line' id='LC253'>					<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC254'>			<span class="p">}</span></div><div class='line' id='LC255'>		<span class="p">}</span></div><div class='line' id='LC256'>		<span class="k">return</span> <span class="p">{</span> <span class="nx">className</span><span class="o">:</span> <span class="nx">className</span><span class="p">,</span> <span class="nx">applyClass</span><span class="o">:</span> <span class="nx">applyClass</span> <span class="p">};</span></div><div class='line' id='LC257'>	<span class="p">};</span></div><div class='line' id='LC258'><br/></div><div class='line' id='LC259'>	<span class="c1">// --[ applyPatches() ]-------------------------------------------------</span></div><div class='line' id='LC260'>	<span class="kd">function</span> <span class="nx">applyPatches</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC261'>		<span class="kd">var</span> <span class="nx">elms</span><span class="p">,</span> <span class="nx">selectorText</span><span class="p">,</span> <span class="nx">patches</span><span class="p">,</span> <span class="nx">domSelectorText</span><span class="p">;</span></div><div class='line' id='LC262'><br/></div><div class='line' id='LC263'>		<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">c</span><span class="o">=</span><span class="mi">0</span><span class="p">;</span> <span class="nx">c</span><span class="o">&lt;</span><span class="nx">domPatches</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">c</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC264'>			<span class="nx">selectorText</span> <span class="o">=</span> <span class="nx">domPatches</span><span class="p">[</span><span class="nx">c</span><span class="p">].</span><span class="nx">selector</span><span class="p">;</span></div><div class='line' id='LC265'>			<span class="nx">patches</span> <span class="o">=</span> <span class="nx">domPatches</span><span class="p">[</span><span class="nx">c</span><span class="p">].</span><span class="nx">patches</span><span class="p">;</span></div><div class='line' id='LC266'><br/></div><div class='line' id='LC267'>			<span class="c1">// Although some selector libraries can find :checked :enabled etc.</span></div><div class='line' id='LC268'>			<span class="c1">// we need to find all elements that could have that state because</span></div><div class='line' id='LC269'>			<span class="c1">// it can be changed by the user.</span></div><div class='line' id='LC270'>			<span class="nx">domSelectorText</span> <span class="o">=</span> <span class="nx">selectorText</span><span class="p">.</span><span class="nx">replace</span><span class="p">(</span><span class="nx">RE_LIBRARY_INCOMPATIBLE_PSEUDOS</span><span class="p">,</span> <span class="nx">EMPTY_STRING</span><span class="p">);</span></div><div class='line' id='LC271'><br/></div><div class='line' id='LC272'>			<span class="c1">// If the dom selector equates to an empty string or ends with</span></div><div class='line' id='LC273'>			<span class="c1">// whitespace then we need to append a universal selector (*) to it.</span></div><div class='line' id='LC274'>			<span class="k">if</span> <span class="p">(</span><span class="nx">domSelectorText</span> <span class="o">==</span> <span class="nx">EMPTY_STRING</span> <span class="o">||</span> <span class="nx">domSelectorText</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="nx">domSelectorText</span><span class="p">.</span><span class="nx">length</span> <span class="o">-</span> <span class="mi">1</span><span class="p">)</span> <span class="o">==</span> <span class="nx">SPACE_STRING</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC275'>				<span class="nx">domSelectorText</span> <span class="o">+=</span> <span class="s2">&quot;*&quot;</span><span class="p">;</span></div><div class='line' id='LC276'>			<span class="p">}</span></div><div class='line' id='LC277'><br/></div><div class='line' id='LC278'>			<span class="c1">// Ensure we catch errors from the selector library</span></div><div class='line' id='LC279'>			<span class="k">try</span> <span class="p">{</span></div><div class='line' id='LC280'>				<span class="nx">elms</span> <span class="o">=</span> <span class="nx">selectorMethod</span><span class="p">(</span> <span class="nx">domSelectorText</span> <span class="p">);</span></div><div class='line' id='LC281'>			<span class="p">}</span> <span class="k">catch</span> <span class="p">(</span><span class="nx">ex</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC282'>				<span class="c1">// #DEBUG_START</span></div><div class='line' id='LC283'>				<span class="nx">log</span><span class="p">(</span> <span class="s2">&quot;Selector &#39;&quot;</span> <span class="o">+</span> <span class="nx">selectorText</span> <span class="o">+</span> <span class="s2">&quot;&#39; threw exception &#39;&quot;</span> <span class="o">+</span> <span class="nx">ex</span> <span class="o">+</span> <span class="s2">&quot;&#39;&quot;</span> <span class="p">);</span></div><div class='line' id='LC284'>				<span class="c1">// #DEBUG_END</span></div><div class='line' id='LC285'>			<span class="p">}</span></div><div class='line' id='LC286'><br/></div><div class='line' id='LC287'><br/></div><div class='line' id='LC288'>			<span class="k">if</span> <span class="p">(</span><span class="nx">elms</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC289'>				<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">d</span> <span class="o">=</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">dl</span> <span class="o">=</span> <span class="nx">elms</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">d</span> <span class="o">&lt;</span> <span class="nx">dl</span><span class="p">;</span> <span class="nx">d</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC290'>					<span class="kd">var</span> <span class="nx">elm</span> <span class="o">=</span> <span class="nx">elms</span><span class="p">[</span><span class="nx">d</span><span class="p">];</span></div><div class='line' id='LC291'>					<span class="kd">var</span> <span class="nx">cssClasses</span> <span class="o">=</span> <span class="nx">elm</span><span class="p">.</span><span class="nx">className</span><span class="p">;</span></div><div class='line' id='LC292'>					<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">f</span> <span class="o">=</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">fl</span> <span class="o">=</span> <span class="nx">patches</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">f</span> <span class="o">&lt;</span> <span class="nx">fl</span><span class="p">;</span> <span class="nx">f</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC293'>						<span class="kd">var</span> <span class="nx">patch</span> <span class="o">=</span> <span class="nx">patches</span><span class="p">[</span><span class="nx">f</span><span class="p">];</span></div><div class='line' id='LC294'>						<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">hasPatch</span><span class="p">(</span><span class="nx">elm</span><span class="p">,</span> <span class="nx">patch</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC295'>							<span class="k">if</span> <span class="p">(</span><span class="nx">patch</span><span class="p">.</span><span class="nx">applyClass</span> <span class="o">&amp;&amp;</span> <span class="p">(</span><span class="nx">patch</span><span class="p">.</span><span class="nx">applyClass</span> <span class="o">===</span> <span class="kc">true</span> <span class="o">||</span> <span class="nx">patch</span><span class="p">.</span><span class="nx">applyClass</span><span class="p">(</span><span class="nx">elm</span><span class="p">)</span> <span class="o">===</span> <span class="kc">true</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC296'>								<span class="nx">cssClasses</span> <span class="o">=</span> <span class="nx">toggleClass</span><span class="p">(</span><span class="nx">cssClasses</span><span class="p">,</span> <span class="nx">patch</span><span class="p">.</span><span class="nx">className</span><span class="p">,</span> <span class="kc">true</span> <span class="p">);</span></div><div class='line' id='LC297'>							<span class="p">}</span></div><div class='line' id='LC298'>						<span class="p">}</span></div><div class='line' id='LC299'>					<span class="p">}</span></div><div class='line' id='LC300'>					<span class="nx">elm</span><span class="p">.</span><span class="nx">className</span> <span class="o">=</span> <span class="nx">cssClasses</span><span class="p">;</span></div><div class='line' id='LC301'>				<span class="p">}</span></div><div class='line' id='LC302'>			<span class="p">}</span></div><div class='line' id='LC303'>		<span class="p">}</span></div><div class='line' id='LC304'>	<span class="p">};</span></div><div class='line' id='LC305'><br/></div><div class='line' id='LC306'>	<span class="c1">// --[ hasPatch() ]-----------------------------------------------------</span></div><div class='line' id='LC307'>	<span class="c1">// checks for the exsistence of a patch on an element</span></div><div class='line' id='LC308'>	<span class="kd">function</span> <span class="nx">hasPatch</span><span class="p">(</span> <span class="nx">elm</span><span class="p">,</span> <span class="nx">patch</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC309'>		<span class="k">return</span> <span class="k">new</span> <span class="nb">RegExp</span><span class="p">(</span><span class="s2">&quot;(^|\\s)&quot;</span> <span class="o">+</span> <span class="nx">patch</span><span class="p">.</span><span class="nx">className</span> <span class="o">+</span> <span class="s2">&quot;(\\s|$)&quot;</span><span class="p">).</span><span class="nx">test</span><span class="p">(</span><span class="nx">elm</span><span class="p">.</span><span class="nx">className</span><span class="p">);</span></div><div class='line' id='LC310'>	<span class="p">};</span></div><div class='line' id='LC311'><br/></div><div class='line' id='LC312'><br/></div><div class='line' id='LC313'>	<span class="c1">// =========================== Utility =================================</span></div><div class='line' id='LC314'><br/></div><div class='line' id='LC315'>	<span class="kd">function</span> <span class="nx">createClassName</span><span class="p">(</span> <span class="nx">className</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC316'>		<span class="k">return</span> <span class="nx">namespace</span> <span class="o">+</span> <span class="s2">&quot;-&quot;</span> <span class="o">+</span> <span class="p">((</span><span class="nx">ieVersion</span> <span class="o">==</span> <span class="mi">6</span> <span class="o">&amp;&amp;</span> <span class="nx">patchIE6MultipleClasses</span><span class="p">)</span> <span class="o">?</span></div><div class='line' id='LC317'>			<span class="nx">ie6PatchID</span><span class="o">++</span></div><div class='line' id='LC318'>		<span class="o">:</span></div><div class='line' id='LC319'>			<span class="nx">className</span><span class="p">.</span><span class="nx">replace</span><span class="p">(</span><span class="nx">RE_PATCH_CLASS_NAME_REPLACE</span><span class="p">,</span> <span class="kd">function</span><span class="p">(</span><span class="nx">a</span><span class="p">)</span> <span class="p">{</span> <span class="k">return</span> <span class="nx">a</span><span class="p">.</span><span class="nx">charCodeAt</span><span class="p">(</span><span class="mi">0</span><span class="p">)</span> <span class="p">}));</span></div><div class='line' id='LC320'>	<span class="p">};</span></div><div class='line' id='LC321'><br/></div><div class='line' id='LC322'>	<span class="c1">// --[ log() ]----------------------------------------------------------</span></div><div class='line' id='LC323'>	<span class="c1">// #DEBUG_START</span></div><div class='line' id='LC324'>	<span class="kd">function</span> <span class="nx">log</span><span class="p">(</span> <span class="nx">message</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC325'>		<span class="k">if</span> <span class="p">(</span><span class="nx">win</span><span class="p">.</span><span class="nx">console</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC326'>			<span class="nx">win</span><span class="p">.</span><span class="nx">console</span><span class="p">.</span><span class="nx">log</span><span class="p">(</span><span class="nx">message</span><span class="p">);</span></div><div class='line' id='LC327'>		<span class="p">}</span></div><div class='line' id='LC328'>	<span class="p">};</span></div><div class='line' id='LC329'>	<span class="c1">// #DEBUG_END</span></div><div class='line' id='LC330'><br/></div><div class='line' id='LC331'>	<span class="c1">// --[ trim() ]---------------------------------------------------------</span></div><div class='line' id='LC332'>	<span class="c1">// removes leading, trailing whitespace from a string</span></div><div class='line' id='LC333'>	<span class="kd">function</span> <span class="nx">trim</span><span class="p">(</span> <span class="nx">text</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC334'>		<span class="k">return</span> <span class="nx">text</span><span class="p">.</span><span class="nx">replace</span><span class="p">(</span><span class="nx">RE_TIDY_TRIM_WHITESPACE</span><span class="p">,</span> <span class="nx">PLACEHOLDER_STRING</span><span class="p">);</span></div><div class='line' id='LC335'>	<span class="p">};</span></div><div class='line' id='LC336'><br/></div><div class='line' id='LC337'>	<span class="c1">// --[ normalizeWhitespace() ]------------------------------------------</span></div><div class='line' id='LC338'>	<span class="c1">// removes leading, trailing and consecutive whitespace from a string</span></div><div class='line' id='LC339'>	<span class="kd">function</span> <span class="nx">normalizeWhitespace</span><span class="p">(</span> <span class="nx">text</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC340'>		<span class="k">return</span> <span class="nx">trim</span><span class="p">(</span><span class="nx">text</span><span class="p">).</span><span class="nx">replace</span><span class="p">(</span><span class="nx">RE_TIDY_CONSECUTIVE_WHITESPACE</span><span class="p">,</span> <span class="nx">SPACE_STRING</span><span class="p">);</span></div><div class='line' id='LC341'>	<span class="p">};</span></div><div class='line' id='LC342'><br/></div><div class='line' id='LC343'>	<span class="c1">// --[ normalizeSelectorWhitespace() ]----------------------------------</span></div><div class='line' id='LC344'>	<span class="c1">// tidies whitespace around selector brackets and combinators</span></div><div class='line' id='LC345'>	<span class="kd">function</span> <span class="nx">normalizeSelectorWhitespace</span><span class="p">(</span> <span class="nx">selectorText</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC346'>		<span class="k">return</span> <span class="nx">normalizeWhitespace</span><span class="p">(</span><span class="nx">selectorText</span><span class="p">.</span></div><div class='line' id='LC347'>			<span class="nx">replace</span><span class="p">(</span><span class="nx">RE_TIDY_TRAILING_WHITESPACE</span><span class="p">,</span> <span class="nx">PLACEHOLDER_STRING</span><span class="p">).</span></div><div class='line' id='LC348'>			<span class="nx">replace</span><span class="p">(</span><span class="nx">RE_TIDY_LEADING_WHITESPACE</span><span class="p">,</span> <span class="nx">PLACEHOLDER_STRING</span><span class="p">)</span></div><div class='line' id='LC349'>		<span class="p">);</span></div><div class='line' id='LC350'>	<span class="p">};</span></div><div class='line' id='LC351'><br/></div><div class='line' id='LC352'>	<span class="c1">// --[ toggleElementClass() ]-------------------------------------------</span></div><div class='line' id='LC353'>	<span class="c1">// toggles a single className on an element</span></div><div class='line' id='LC354'>	<span class="kd">function</span> <span class="nx">toggleElementClass</span><span class="p">(</span> <span class="nx">elm</span><span class="p">,</span> <span class="nx">className</span><span class="p">,</span> <span class="nx">on</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC355'>		<span class="kd">var</span> <span class="nx">oldClassName</span> <span class="o">=</span> <span class="nx">elm</span><span class="p">.</span><span class="nx">className</span><span class="p">;</span></div><div class='line' id='LC356'>		<span class="kd">var</span> <span class="nx">newClassName</span> <span class="o">=</span> <span class="nx">toggleClass</span><span class="p">(</span><span class="nx">oldClassName</span><span class="p">,</span> <span class="nx">className</span><span class="p">,</span> <span class="nx">on</span><span class="p">);</span></div><div class='line' id='LC357'>		<span class="k">if</span> <span class="p">(</span><span class="nx">newClassName</span> <span class="o">!=</span> <span class="nx">oldClassName</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC358'>			<span class="nx">elm</span><span class="p">.</span><span class="nx">className</span> <span class="o">=</span> <span class="nx">newClassName</span><span class="p">;</span></div><div class='line' id='LC359'>			<span class="nx">elm</span><span class="p">.</span><span class="nx">parentNode</span><span class="p">.</span><span class="nx">className</span> <span class="o">+=</span> <span class="nx">EMPTY_STRING</span><span class="p">;</span></div><div class='line' id='LC360'>		<span class="p">}</span></div><div class='line' id='LC361'>	<span class="p">};</span></div><div class='line' id='LC362'><br/></div><div class='line' id='LC363'>	<span class="c1">// --[ toggleClass() ]--------------------------------------------------</span></div><div class='line' id='LC364'>	<span class="c1">// adds / removes a className from a string of classNames. Used to </span></div><div class='line' id='LC365'>	<span class="c1">// manage multiple class changes without forcing a DOM redraw</span></div><div class='line' id='LC366'>	<span class="kd">function</span> <span class="nx">toggleClass</span><span class="p">(</span> <span class="nx">classList</span><span class="p">,</span> <span class="nx">className</span><span class="p">,</span> <span class="nx">on</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC367'>		<span class="kd">var</span> <span class="nx">re</span> <span class="o">=</span> <span class="nb">RegExp</span><span class="p">(</span><span class="s2">&quot;(^|\\s)&quot;</span> <span class="o">+</span> <span class="nx">className</span> <span class="o">+</span> <span class="s2">&quot;(\\s|$)&quot;</span><span class="p">);</span></div><div class='line' id='LC368'>		<span class="kd">var</span> <span class="nx">classExists</span> <span class="o">=</span> <span class="nx">re</span><span class="p">.</span><span class="nx">test</span><span class="p">(</span><span class="nx">classList</span><span class="p">);</span></div><div class='line' id='LC369'>		<span class="k">if</span> <span class="p">(</span><span class="nx">on</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC370'>			<span class="k">return</span> <span class="nx">classExists</span> <span class="o">?</span> <span class="nx">classList</span> <span class="o">:</span> <span class="nx">classList</span> <span class="o">+</span> <span class="nx">SPACE_STRING</span> <span class="o">+</span> <span class="nx">className</span><span class="p">;</span></div><div class='line' id='LC371'>		<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC372'>			<span class="k">return</span> <span class="nx">classExists</span> <span class="o">?</span> <span class="nx">trim</span><span class="p">(</span><span class="nx">classList</span><span class="p">.</span><span class="nx">replace</span><span class="p">(</span><span class="nx">re</span><span class="p">,</span> <span class="nx">PLACEHOLDER_STRING</span><span class="p">))</span> <span class="o">:</span> <span class="nx">classList</span><span class="p">;</span></div><div class='line' id='LC373'>		<span class="p">}</span></div><div class='line' id='LC374'>	<span class="p">};</span></div><div class='line' id='LC375'><br/></div><div class='line' id='LC376'>	<span class="c1">// --[ addEvent() ]-----------------------------------------------------</span></div><div class='line' id='LC377'>	<span class="kd">function</span> <span class="nx">addEvent</span><span class="p">(</span><span class="nx">elm</span><span class="p">,</span> <span class="nx">eventName</span><span class="p">,</span> <span class="nx">eventHandler</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC378'>		<span class="nx">elm</span><span class="p">.</span><span class="nx">attachEvent</span><span class="p">(</span><span class="s2">&quot;on&quot;</span> <span class="o">+</span> <span class="nx">eventName</span><span class="p">,</span> <span class="nx">eventHandler</span><span class="p">);</span></div><div class='line' id='LC379'>	<span class="p">};</span></div><div class='line' id='LC380'><br/></div><div class='line' id='LC381'>	<span class="c1">// --[ getXHRObject() ]-------------------------------------------------</span></div><div class='line' id='LC382'>	<span class="kd">function</span> <span class="nx">getXHRObject</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC383'>		<span class="k">if</span> <span class="p">(</span><span class="nx">win</span><span class="p">.</span><span class="nx">XMLHttpRequest</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC384'>			<span class="k">return</span> <span class="k">new</span> <span class="nx">XMLHttpRequest</span><span class="p">;</span></div><div class='line' id='LC385'>		<span class="p">}</span></div><div class='line' id='LC386'>		<span class="k">try</span>	<span class="p">{</span> </div><div class='line' id='LC387'>			<span class="k">return</span> <span class="k">new</span> <span class="nx">ActiveXObject</span><span class="p">(</span><span class="s1">&#39;Microsoft.XMLHTTP&#39;</span><span class="p">);</span></div><div class='line' id='LC388'>		<span class="p">}</span> <span class="k">catch</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span> </div><div class='line' id='LC389'>			<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC390'>		<span class="p">}</span></div><div class='line' id='LC391'>	<span class="p">};</span></div><div class='line' id='LC392'><br/></div><div class='line' id='LC393'>	<span class="c1">// --[ loadStyleSheet() ]-----------------------------------------------</span></div><div class='line' id='LC394'>	<span class="kd">function</span> <span class="nx">loadStyleSheet</span><span class="p">(</span> <span class="nx">url</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC395'>		<span class="nx">xhr</span><span class="p">.</span><span class="nx">open</span><span class="p">(</span><span class="s2">&quot;GET&quot;</span><span class="p">,</span> <span class="nx">url</span><span class="p">,</span> <span class="kc">false</span><span class="p">);</span></div><div class='line' id='LC396'>		<span class="nx">xhr</span><span class="p">.</span><span class="nx">send</span><span class="p">();</span></div><div class='line' id='LC397'>		<span class="k">return</span> <span class="p">(</span><span class="nx">xhr</span><span class="p">.</span><span class="nx">status</span><span class="o">==</span><span class="mi">200</span><span class="p">)</span> <span class="o">?</span> <span class="nx">xhr</span><span class="p">.</span><span class="nx">responseText</span> <span class="o">:</span> <span class="nx">EMPTY_STRING</span><span class="p">;</span>	</div><div class='line' id='LC398'>	<span class="p">};</span></div><div class='line' id='LC399'><br/></div><div class='line' id='LC400'>	<span class="c1">// --[ resolveUrl() ]---------------------------------------------------</span></div><div class='line' id='LC401'>	<span class="c1">// Converts a URL fragment to a fully qualified URL using the specified</span></div><div class='line' id='LC402'>	<span class="c1">// context URL. Returns null if same-origin policy is broken</span></div><div class='line' id='LC403'>	<span class="kd">function</span> <span class="nx">resolveUrl</span><span class="p">(</span> <span class="nx">url</span><span class="p">,</span> <span class="nx">contextUrl</span><span class="p">,</span> <span class="nx">ignoreSameOriginPolicy</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC404'><br/></div><div class='line' id='LC405'>		<span class="kd">function</span> <span class="nx">getProtocol</span><span class="p">(</span> <span class="nx">url</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC406'>			<span class="k">return</span> <span class="nx">url</span><span class="p">.</span><span class="nx">substring</span><span class="p">(</span><span class="mi">0</span><span class="p">,</span> <span class="nx">url</span><span class="p">.</span><span class="nx">indexOf</span><span class="p">(</span><span class="s2">&quot;//&quot;</span><span class="p">));</span></div><div class='line' id='LC407'>		<span class="p">};</span></div><div class='line' id='LC408'><br/></div><div class='line' id='LC409'>		<span class="kd">function</span> <span class="nx">getProtocolAndHost</span><span class="p">(</span> <span class="nx">url</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC410'>			<span class="k">return</span> <span class="nx">url</span><span class="p">.</span><span class="nx">substring</span><span class="p">(</span><span class="mi">0</span><span class="p">,</span> <span class="nx">url</span><span class="p">.</span><span class="nx">indexOf</span><span class="p">(</span><span class="s2">&quot;/&quot;</span><span class="p">,</span> <span class="mi">8</span><span class="p">));</span></div><div class='line' id='LC411'>		<span class="p">};</span></div><div class='line' id='LC412'><br/></div><div class='line' id='LC413'>		<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">contextUrl</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC414'>			<span class="nx">contextUrl</span> <span class="o">=</span> <span class="nx">baseUrl</span><span class="p">;</span></div><div class='line' id='LC415'>		<span class="p">}</span></div><div class='line' id='LC416'><br/></div><div class='line' id='LC417'>		<span class="c1">// protocol-relative path</span></div><div class='line' id='LC418'>		<span class="k">if</span> <span class="p">(</span><span class="nx">url</span><span class="p">.</span><span class="nx">substring</span><span class="p">(</span><span class="mi">0</span><span class="p">,</span><span class="mi">2</span><span class="p">)</span><span class="o">==</span><span class="s2">&quot;//&quot;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC419'>			<span class="nx">url</span> <span class="o">=</span> <span class="nx">getProtocol</span><span class="p">(</span><span class="nx">contextUrl</span><span class="p">)</span> <span class="o">+</span> <span class="nx">url</span><span class="p">;</span></div><div class='line' id='LC420'>		<span class="p">}</span></div><div class='line' id='LC421'><br/></div><div class='line' id='LC422'>		<span class="c1">// absolute path</span></div><div class='line' id='LC423'>		<span class="k">if</span> <span class="p">(</span><span class="sr">/^https?:\/\//i</span><span class="p">.</span><span class="nx">test</span><span class="p">(</span><span class="nx">url</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC424'>			<span class="k">return</span> <span class="o">!</span><span class="nx">ignoreSameOriginPolicy</span> <span class="o">&amp;&amp;</span> <span class="nx">getProtocolAndHost</span><span class="p">(</span><span class="nx">contextUrl</span><span class="p">)</span> <span class="o">!=</span> <span class="nx">getProtocolAndHost</span><span class="p">(</span><span class="nx">url</span><span class="p">)</span> <span class="o">?</span> <span class="kc">null</span> <span class="o">:</span> <span class="nx">url</span> <span class="p">;</span></div><div class='line' id='LC425'>		<span class="p">}</span></div><div class='line' id='LC426'><br/></div><div class='line' id='LC427'>		<span class="c1">// root-relative path</span></div><div class='line' id='LC428'>		<span class="k">if</span> <span class="p">(</span><span class="nx">url</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="mi">0</span><span class="p">)</span><span class="o">==</span><span class="s2">&quot;/&quot;</span><span class="p">)</span>	<span class="p">{</span></div><div class='line' id='LC429'>			<span class="k">return</span> <span class="nx">getProtocolAndHost</span><span class="p">(</span><span class="nx">contextUrl</span><span class="p">)</span> <span class="o">+</span> <span class="nx">url</span><span class="p">;</span></div><div class='line' id='LC430'>		<span class="p">}</span></div><div class='line' id='LC431'><br/></div><div class='line' id='LC432'>		<span class="c1">// relative path</span></div><div class='line' id='LC433'>		<span class="kd">var</span> <span class="nx">contextUrlPath</span> <span class="o">=</span> <span class="nx">contextUrl</span><span class="p">.</span><span class="nx">split</span><span class="p">(</span><span class="sr">/[?#]/</span><span class="p">)[</span><span class="mi">0</span><span class="p">];</span> <span class="c1">// ignore query string in the contextUrl	</span></div><div class='line' id='LC434'>		<span class="k">if</span> <span class="p">(</span><span class="nx">url</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="mi">0</span><span class="p">)</span> <span class="o">!=</span> <span class="s2">&quot;?&quot;</span> <span class="o">&amp;&amp;</span> <span class="nx">contextUrlPath</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="nx">contextUrlPath</span><span class="p">.</span><span class="nx">length</span> <span class="o">-</span> <span class="mi">1</span><span class="p">)</span> <span class="o">!=</span> <span class="s2">&quot;/&quot;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC435'>			<span class="nx">contextUrlPath</span> <span class="o">=</span> <span class="nx">contextUrlPath</span><span class="p">.</span><span class="nx">substring</span><span class="p">(</span><span class="mi">0</span><span class="p">,</span> <span class="nx">contextUrlPath</span><span class="p">.</span><span class="nx">lastIndexOf</span><span class="p">(</span><span class="s2">&quot;/&quot;</span><span class="p">)</span> <span class="o">+</span> <span class="mi">1</span><span class="p">);</span></div><div class='line' id='LC436'>		<span class="p">}</span></div><div class='line' id='LC437'><br/></div><div class='line' id='LC438'>		<span class="k">return</span> <span class="nx">contextUrlPath</span> <span class="o">+</span> <span class="nx">url</span><span class="p">;</span></div><div class='line' id='LC439'>	<span class="p">};</span></div><div class='line' id='LC440'><br/></div><div class='line' id='LC441'>	<span class="c1">// --[ parseStyleSheet() ]----------------------------------------------</span></div><div class='line' id='LC442'>	<span class="c1">// Downloads the stylesheet specified by the URL, removes it&#39;s comments</span></div><div class='line' id='LC443'>	<span class="c1">// and recursivly replaces @import rules with their contents, ultimately</span></div><div class='line' id='LC444'>	<span class="c1">// returning the full cssText.</span></div><div class='line' id='LC445'>	<span class="kd">function</span> <span class="nx">parseStyleSheet</span><span class="p">(</span> <span class="nx">url</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC446'>		<span class="k">if</span> <span class="p">(</span><span class="nx">url</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC447'>			<span class="k">return</span> <span class="nx">loadStyleSheet</span><span class="p">(</span><span class="nx">url</span><span class="p">).</span><span class="nx">replace</span><span class="p">(</span><span class="nx">RE_COMMENT</span><span class="p">,</span> <span class="nx">EMPTY_STRING</span><span class="p">).</span></div><div class='line' id='LC448'>			<span class="nx">replace</span><span class="p">(</span><span class="nx">RE_IMPORT</span><span class="p">,</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">match</span><span class="p">,</span> <span class="nx">quoteChar</span><span class="p">,</span> <span class="nx">importUrl</span><span class="p">,</span> <span class="nx">quoteChar2</span><span class="p">,</span> <span class="nx">importUrl2</span><span class="p">,</span> <span class="nx">media</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC449'>				<span class="kd">var</span> <span class="nx">cssText</span> <span class="o">=</span> <span class="nx">parseStyleSheet</span><span class="p">(</span><span class="nx">resolveUrl</span><span class="p">(</span><span class="nx">importUrl</span> <span class="o">||</span> <span class="nx">importUrl2</span><span class="p">,</span> <span class="nx">url</span><span class="p">));</span></div><div class='line' id='LC450'>				<span class="k">return</span> <span class="p">(</span><span class="nx">media</span><span class="p">)</span> <span class="o">?</span> <span class="s2">&quot;@media &quot;</span> <span class="o">+</span> <span class="nx">media</span> <span class="o">+</span> <span class="s2">&quot; {&quot;</span> <span class="o">+</span> <span class="nx">cssText</span> <span class="o">+</span> <span class="s2">&quot;}&quot;</span> <span class="o">:</span> <span class="nx">cssText</span><span class="p">;</span></div><div class='line' id='LC451'>			<span class="p">}).</span></div><div class='line' id='LC452'>			<span class="nx">replace</span><span class="p">(</span><span class="nx">RE_ASSET_URL</span><span class="p">,</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">match</span><span class="p">,</span> <span class="nx">isBehavior</span><span class="p">,</span> <span class="nx">quoteChar</span><span class="p">,</span> <span class="nx">assetUrl</span> <span class="p">)</span> <span class="p">{</span> </div><div class='line' id='LC453'>				<span class="nx">quoteChar</span> <span class="o">=</span> <span class="nx">quoteChar</span> <span class="o">||</span> <span class="nx">EMPTY_STRING</span><span class="p">;</span></div><div class='line' id='LC454'>				<span class="k">return</span> <span class="nx">isBehavior</span> <span class="o">?</span> <span class="nx">match</span> <span class="o">:</span> <span class="s2">&quot; url(&quot;</span> <span class="o">+</span> <span class="nx">quoteChar</span> <span class="o">+</span> <span class="nx">resolveUrl</span><span class="p">(</span><span class="nx">assetUrl</span><span class="p">,</span> <span class="nx">url</span><span class="p">,</span> <span class="kc">true</span><span class="p">)</span> <span class="o">+</span> <span class="nx">quoteChar</span> <span class="o">+</span> <span class="s2">&quot;) &quot;</span><span class="p">;</span> </div><div class='line' id='LC455'>			<span class="p">});</span></div><div class='line' id='LC456'>		<span class="p">}</span></div><div class='line' id='LC457'>		<span class="k">return</span> <span class="nx">EMPTY_STRING</span><span class="p">;</span></div><div class='line' id='LC458'>	<span class="p">};</span></div><div class='line' id='LC459'><br/></div><div class='line' id='LC460'>	<span class="c1">// --[ getStyleSheets() ]-----------------------------------------------</span></div><div class='line' id='LC461'>	<span class="kd">function</span> <span class="nx">getStyleSheets</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC462'>		<span class="kd">var</span> <span class="nx">url</span><span class="p">,</span> <span class="nx">stylesheet</span><span class="p">;</span></div><div class='line' id='LC463'>		<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">c</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">c</span> <span class="o">&lt;</span> <span class="nx">doc</span><span class="p">.</span><span class="nx">styleSheets</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">c</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC464'>			<span class="nx">stylesheet</span> <span class="o">=</span> <span class="nx">doc</span><span class="p">.</span><span class="nx">styleSheets</span><span class="p">[</span><span class="nx">c</span><span class="p">];</span></div><div class='line' id='LC465'>			<span class="k">if</span> <span class="p">(</span><span class="nx">stylesheet</span><span class="p">.</span><span class="nx">href</span> <span class="o">!=</span> <span class="nx">EMPTY_STRING</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC466'>				<span class="nx">url</span> <span class="o">=</span> <span class="nx">resolveUrl</span><span class="p">(</span><span class="nx">stylesheet</span><span class="p">.</span><span class="nx">href</span><span class="p">);</span></div><div class='line' id='LC467'>				<span class="k">if</span> <span class="p">(</span><span class="nx">url</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC468'>					<span class="nx">stylesheet</span><span class="p">.</span><span class="nx">cssText</span> <span class="o">=</span> <span class="nx">stylesheet</span><span class="p">[</span><span class="s2">&quot;rawCssText&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="nx">patchStyleSheet</span><span class="p">(</span> <span class="nx">parseStyleSheet</span><span class="p">(</span> <span class="nx">url</span> <span class="p">)</span> <span class="p">);</span></div><div class='line' id='LC469'>				<span class="p">}</span></div><div class='line' id='LC470'>			<span class="p">}</span></div><div class='line' id='LC471'>		<span class="p">}</span></div><div class='line' id='LC472'>	<span class="p">};</span></div><div class='line' id='LC473'><br/></div><div class='line' id='LC474'>	<span class="c1">// --[ init() ]---------------------------------------------------------</span></div><div class='line' id='LC475'>	<span class="kd">function</span> <span class="nx">init</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC476'>		<span class="nx">applyPatches</span><span class="p">();</span></div><div class='line' id='LC477'><br/></div><div class='line' id='LC478'>		<span class="c1">// :enabled &amp; :disabled polling script (since we can&#39;t hook </span></div><div class='line' id='LC479'>		<span class="c1">// onpropertychange event when an element is disabled) </span></div><div class='line' id='LC480'>		<span class="k">if</span> <span class="p">(</span><span class="nx">enabledWatchers</span><span class="p">.</span><span class="nx">length</span> <span class="o">&gt;</span> <span class="mi">0</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC481'>			<span class="nx">setInterval</span><span class="p">(</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC482'>				<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">c</span> <span class="o">=</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">cl</span> <span class="o">=</span> <span class="nx">enabledWatchers</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">c</span> <span class="o">&lt;</span> <span class="nx">cl</span><span class="p">;</span> <span class="nx">c</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC483'>					<span class="kd">var</span> <span class="nx">e</span> <span class="o">=</span> <span class="nx">enabledWatchers</span><span class="p">[</span><span class="nx">c</span><span class="p">];</span></div><div class='line' id='LC484'>					<span class="k">if</span> <span class="p">(</span><span class="nx">e</span><span class="p">.</span><span class="nx">disabled</span> <span class="o">!==</span> <span class="nx">e</span><span class="p">.</span><span class="nx">$disabled</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC485'>						<span class="k">if</span> <span class="p">(</span><span class="nx">e</span><span class="p">.</span><span class="nx">disabled</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC486'>							<span class="nx">e</span><span class="p">.</span><span class="nx">disabled</span> <span class="o">=</span> <span class="kc">false</span><span class="p">;</span></div><div class='line' id='LC487'>							<span class="nx">e</span><span class="p">.</span><span class="nx">$disabled</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC488'>							<span class="nx">e</span><span class="p">.</span><span class="nx">disabled</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC489'>						<span class="p">}</span></div><div class='line' id='LC490'>						<span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC491'>							<span class="nx">e</span><span class="p">.</span><span class="nx">$disabled</span> <span class="o">=</span> <span class="nx">e</span><span class="p">.</span><span class="nx">disabled</span><span class="p">;</span></div><div class='line' id='LC492'>						<span class="p">}</span></div><div class='line' id='LC493'>					<span class="p">}</span></div><div class='line' id='LC494'>				<span class="p">}</span></div><div class='line' id='LC495'>			<span class="p">},</span> <span class="mi">250</span><span class="p">)</span></div><div class='line' id='LC496'>		<span class="p">}</span></div><div class='line' id='LC497'>	<span class="p">};</span></div><div class='line' id='LC498'><br/></div><div class='line' id='LC499'>	<span class="c1">// Determine the baseUrl and download the stylesheets</span></div><div class='line' id='LC500'>	<span class="kd">var</span> <span class="nx">baseTags</span> <span class="o">=</span> <span class="nx">doc</span><span class="p">.</span><span class="nx">getElementsByTagName</span><span class="p">(</span><span class="s2">&quot;BASE&quot;</span><span class="p">);</span></div><div class='line' id='LC501'>	<span class="kd">var</span> <span class="nx">baseUrl</span> <span class="o">=</span> <span class="p">(</span><span class="nx">baseTags</span><span class="p">.</span><span class="nx">length</span> <span class="o">&gt;</span> <span class="mi">0</span><span class="p">)</span> <span class="o">?</span> <span class="nx">baseTags</span><span class="p">[</span><span class="mi">0</span><span class="p">].</span><span class="nx">href</span> <span class="o">:</span> <span class="nx">doc</span><span class="p">.</span><span class="nx">location</span><span class="p">.</span><span class="nx">href</span><span class="p">;</span></div><div class='line' id='LC502'>	<span class="nx">getStyleSheets</span><span class="p">();</span></div><div class='line' id='LC503'><br/></div><div class='line' id='LC504'>	<span class="c1">// Bind selectivizr to the ContentLoaded event. </span></div><div class='line' id='LC505'>	<span class="nx">ContentLoaded</span><span class="p">(</span><span class="nx">win</span><span class="p">,</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC506'>		<span class="c1">// Determine the &quot;best fit&quot; selector engine</span></div><div class='line' id='LC507'>		<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">engine</span> <span class="k">in</span> <span class="nx">selectorEngines</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC508'>			<span class="kd">var</span> <span class="nx">members</span><span class="p">,</span> <span class="nx">member</span><span class="p">,</span> <span class="nx">context</span> <span class="o">=</span> <span class="nx">win</span><span class="p">;</span></div><div class='line' id='LC509'>			<span class="k">if</span> <span class="p">(</span><span class="nx">win</span><span class="p">[</span><span class="nx">engine</span><span class="p">])</span> <span class="p">{</span></div><div class='line' id='LC510'>				<span class="nx">members</span> <span class="o">=</span> <span class="nx">selectorEngines</span><span class="p">[</span><span class="nx">engine</span><span class="p">].</span><span class="nx">replace</span><span class="p">(</span><span class="s2">&quot;*&quot;</span><span class="p">,</span> <span class="nx">engine</span><span class="p">).</span><span class="nx">split</span><span class="p">(</span><span class="s2">&quot;.&quot;</span><span class="p">);</span></div><div class='line' id='LC511'>				<span class="k">while</span> <span class="p">((</span><span class="nx">member</span> <span class="o">=</span> <span class="nx">members</span><span class="p">.</span><span class="nx">shift</span><span class="p">())</span> <span class="o">&amp;&amp;</span> <span class="p">(</span><span class="nx">context</span> <span class="o">=</span> <span class="nx">context</span><span class="p">[</span><span class="nx">member</span><span class="p">]))</span> <span class="p">{}</span></div><div class='line' id='LC512'>				<span class="k">if</span> <span class="p">(</span><span class="k">typeof</span> <span class="nx">context</span> <span class="o">==</span> <span class="s2">&quot;function&quot;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC513'>					<span class="nx">selectorMethod</span> <span class="o">=</span> <span class="nx">context</span><span class="p">;</span></div><div class='line' id='LC514'>					<span class="nx">init</span><span class="p">();</span></div><div class='line' id='LC515'>					<span class="k">return</span><span class="p">;</span></div><div class='line' id='LC516'>				<span class="p">}</span></div><div class='line' id='LC517'>			<span class="p">}</span></div><div class='line' id='LC518'>		<span class="p">}</span></div><div class='line' id='LC519'>	<span class="p">});</span></div><div class='line' id='LC520'><br/></div><div class='line' id='LC521'><br/></div><div class='line' id='LC522'><br/></div><div class='line' id='LC523'>	<span class="cm">/*!</span></div><div class='line' id='LC524'><span class="cm">	 * ContentLoaded.js by Diego Perini, modified for IE&lt;9 only (to save space)</span></div><div class='line' id='LC525'><span class="cm">	 *</span></div><div class='line' id='LC526'><span class="cm">	 * Author: Diego Perini (diego.perini at gmail.com)</span></div><div class='line' id='LC527'><span class="cm">	 * Summary: cross-browser wrapper for DOMContentLoaded</span></div><div class='line' id='LC528'><span class="cm">	 * Updated: 20101020</span></div><div class='line' id='LC529'><span class="cm">	 * License: MIT</span></div><div class='line' id='LC530'><span class="cm">	 * Version: 1.2</span></div><div class='line' id='LC531'><span class="cm">	 *</span></div><div class='line' id='LC532'><span class="cm">	 * URL:</span></div><div class='line' id='LC533'><span class="cm">	 * http://javascript.nwbox.com/ContentLoaded/</span></div><div class='line' id='LC534'><span class="cm">	 * http://javascript.nwbox.com/ContentLoaded/MIT-LICENSE</span></div><div class='line' id='LC535'><span class="cm">	 *</span></div><div class='line' id='LC536'><span class="cm">	 */</span></div><div class='line' id='LC537'><br/></div><div class='line' id='LC538'>	<span class="c1">// @w window reference</span></div><div class='line' id='LC539'>	<span class="c1">// @f function reference</span></div><div class='line' id='LC540'>	<span class="kd">function</span> <span class="nx">ContentLoaded</span><span class="p">(</span><span class="nx">win</span><span class="p">,</span> <span class="nx">fn</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC541'><br/></div><div class='line' id='LC542'>		<span class="kd">var</span> <span class="nx">done</span> <span class="o">=</span> <span class="kc">false</span><span class="p">,</span> <span class="nx">top</span> <span class="o">=</span> <span class="kc">true</span><span class="p">,</span></div><div class='line' id='LC543'>		<span class="nx">init</span> <span class="o">=</span> <span class="kd">function</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC544'>			<span class="k">if</span> <span class="p">(</span><span class="nx">e</span><span class="p">.</span><span class="nx">type</span> <span class="o">==</span> <span class="s2">&quot;readystatechange&quot;</span> <span class="o">&amp;&amp;</span> <span class="nx">doc</span><span class="p">.</span><span class="nx">readyState</span> <span class="o">!=</span> <span class="s2">&quot;complete&quot;</span><span class="p">)</span> <span class="k">return</span><span class="p">;</span></div><div class='line' id='LC545'>			<span class="p">(</span><span class="nx">e</span><span class="p">.</span><span class="nx">type</span> <span class="o">==</span> <span class="s2">&quot;load&quot;</span> <span class="o">?</span> <span class="nx">win</span> <span class="o">:</span> <span class="nx">doc</span><span class="p">).</span><span class="nx">detachEvent</span><span class="p">(</span><span class="s2">&quot;on&quot;</span> <span class="o">+</span> <span class="nx">e</span><span class="p">.</span><span class="nx">type</span><span class="p">,</span> <span class="nx">init</span><span class="p">,</span> <span class="kc">false</span><span class="p">);</span></div><div class='line' id='LC546'>			<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">done</span> <span class="o">&amp;&amp;</span> <span class="p">(</span><span class="nx">done</span> <span class="o">=</span> <span class="kc">true</span><span class="p">))</span> <span class="nx">fn</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="nx">win</span><span class="p">,</span> <span class="nx">e</span><span class="p">.</span><span class="nx">type</span> <span class="o">||</span> <span class="nx">e</span><span class="p">);</span></div><div class='line' id='LC547'>		<span class="p">},</span></div><div class='line' id='LC548'>		<span class="nx">poll</span> <span class="o">=</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC549'>			<span class="k">try</span> <span class="p">{</span> <span class="nx">root</span><span class="p">.</span><span class="nx">doScroll</span><span class="p">(</span><span class="s2">&quot;left&quot;</span><span class="p">);</span> <span class="p">}</span> <span class="k">catch</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span> <span class="nx">setTimeout</span><span class="p">(</span><span class="nx">poll</span><span class="p">,</span> <span class="mi">50</span><span class="p">);</span> <span class="k">return</span><span class="p">;</span> <span class="p">}</span></div><div class='line' id='LC550'>			<span class="nx">init</span><span class="p">(</span><span class="s1">&#39;poll&#39;</span><span class="p">);</span></div><div class='line' id='LC551'>		<span class="p">};</span></div><div class='line' id='LC552'><br/></div><div class='line' id='LC553'>		<span class="k">if</span> <span class="p">(</span><span class="nx">doc</span><span class="p">.</span><span class="nx">readyState</span> <span class="o">==</span> <span class="s2">&quot;complete&quot;</span><span class="p">)</span> <span class="nx">fn</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="nx">win</span><span class="p">,</span> <span class="nx">EMPTY_STRING</span><span class="p">);</span></div><div class='line' id='LC554'>		<span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC555'>			<span class="k">if</span> <span class="p">(</span><span class="nx">doc</span><span class="p">.</span><span class="nx">createEventObject</span> <span class="o">&amp;&amp;</span> <span class="nx">root</span><span class="p">.</span><span class="nx">doScroll</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC556'>				<span class="k">try</span> <span class="p">{</span> <span class="nx">top</span> <span class="o">=</span> <span class="o">!</span><span class="nx">win</span><span class="p">.</span><span class="nx">frameElement</span><span class="p">;</span> <span class="p">}</span> <span class="k">catch</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span> <span class="p">}</span></div><div class='line' id='LC557'>				<span class="k">if</span> <span class="p">(</span><span class="nx">top</span><span class="p">)</span> <span class="nx">poll</span><span class="p">();</span></div><div class='line' id='LC558'>			<span class="p">}</span></div><div class='line' id='LC559'>			<span class="nx">addEvent</span><span class="p">(</span><span class="nx">doc</span><span class="p">,</span><span class="s2">&quot;readystatechange&quot;</span><span class="p">,</span> <span class="nx">init</span><span class="p">);</span></div><div class='line' id='LC560'>			<span class="nx">addEvent</span><span class="p">(</span><span class="nx">win</span><span class="p">,</span><span class="s2">&quot;load&quot;</span><span class="p">,</span> <span class="nx">init</span><span class="p">);</span></div><div class='line' id='LC561'>		<span class="p">}</span></div><div class='line' id='LC562'>	<span class="p">};</span></div><div class='line' id='LC563'><span class="p">})(</span><span class="k">this</span><span class="p">);</span></div></pre></div></td>
         </tr>
       </table>
  </div>

  </div>
</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <form accept-charset="UTF-8" class="js-jump-to-line-form">
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" autofocus>
    <button type="submit" class="button">Go</button>
  </form>
</div>

        </div>

      </div><!-- /.repo-container -->
      <div class="modal-backdrop"></div>
    </div><!-- /.container -->
  </div><!-- /.site -->


    </div><!-- /.wrapper -->

      <div class="container">
  <div class="site-footer">
    <ul class="site-footer-links right">
      <li><a href="https://status.github.com/">Status</a></li>
      <li><a href="http://developer.github.com">API</a></li>
      <li><a href="http://training.github.com">Training</a></li>
      <li><a href="http://shop.github.com">Shop</a></li>
      <li><a href="/blog">Blog</a></li>
      <li><a href="/about">About</a></li>

    </ul>

    <a href="/" aria-label="Homepage">
      <span class="mega-octicon octicon-mark-github" title="GitHub"></span>
    </a>

    <ul class="site-footer-links">
      <li>&copy; 2014 <span title="0.08355s from github-fe117-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="/site/terms">Terms</a></li>
        <li><a href="/site/privacy">Privacy</a></li>
        <li><a href="/security">Security</a></li>
        <li><a href="/contact">Contact</a></li>
    </ul>
  </div><!-- /.site-footer -->
</div><!-- /.container -->


    <div class="fullscreen-overlay js-fullscreen-overlay" id="fullscreen_overlay">
  <div class="fullscreen-container">
    <div class="textarea-wrap">
      <textarea name="fullscreen-contents" id="fullscreen-contents" class="fullscreen-contents js-fullscreen-contents" placeholder="" data-suggester="fullscreen_suggester"></textarea>
    </div>
  </div>
  <div class="fullscreen-sidebar">
    <a href="#" class="exit-fullscreen js-exit-fullscreen tooltipped tooltipped-w" aria-label="Exit Zen Mode">
      <span class="mega-octicon octicon-screen-normal"></span>
    </a>
    <a href="#" class="theme-switcher js-theme-switcher tooltipped tooltipped-w"
      aria-label="Switch themes">
      <span class="octicon octicon-color-mode"></span>
    </a>
  </div>
</div>



    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <a href="#" class="octicon octicon-x close js-ajax-error-dismiss" aria-label="Dismiss error"></a>
      Something went wrong with that request. Please try again.
    </div>


      <script crossorigin="anonymous" src="https://assets-cdn.github.com/assets/frameworks-caa5b172e276e6cfb9657534025e7be159dc931e.js" type="text/javascript"></script>
      <script async="async" crossorigin="anonymous" src="https://assets-cdn.github.com/assets/github-62b4639b173285601517c2ca2821b6fe5c9ebcd2.js" type="text/javascript"></script>
      
      
        <script async src="https://www.google-analytics.com/analytics.js"></script>
  </body>
</html>

