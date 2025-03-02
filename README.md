# medipro

## メンバー
- ぬかにわ
- えぐち
- まくら

## ディレクトリ構成

```
medipro/
├── src/
│ ├── model/ # ゲームのロジックやデータを管理するクラス
│ ├── view/ # UI を表示するクラス（Swing の GUI コンポーネントを含む）
│ ├── controller/ # ユーザーの入力を処理し、Model と View をつなぐクラス
│ ├── utils/ # 共通のユーティリティクラスや定数
│ └── Main.java # エントリポイント
└── resources/ # 画像、サウンドなどのアセット
```

### 各ディレクトリの役割

- **model/**: ゲームのルールやデータ管理、ビジネスロジックを担当。例えば、ゲームのスコアやプレイヤーの状態、ゲームステートのクラス。

- **view/**: ユーザーに表示される部分を担当。Swing コンポーネント（`JFrame`、`JPanel`など）を使って UI を構築し、プレイヤーに見える画面や画面要素を扱う。

- **controller/**: ユーザー入力（キーボードやマウスの操作）を処理し、Model と View のやりとりを行う。ユーザーの操作をゲームロジックに反映させたり、UI の更新を指示する役割。

- **utils/**: ゲーム全体で使われる共通のユーティリティクラスや定数を格納。たとえば、画面サイズや定数の定義、便利メソッドなどをここに置く。

- **resources/**: 画像、サウンド、フォントなどの外部リソースを配置。ファイルのロードや管理が容易になる。

## 初期構成

1. [Project Manager for Java](https://github.com/microsoft/vscode-java-dependency?tab=readme-ov-file#project-manager-for-java)を使用してプロジェクトを管理します。README を読んでおいてください。
2. 必要な拡張機能があります。VSCodeの拡張機能タブの検索に`@recommended`を入れて、全て入っているか確認してください。
3. 起動するには`F5`を押してください。自動でコンパイルして立ち上がってきます。


## 想定コマンド
| コマンド| 内容 |オプション|
| ---- | ---- |----|
|move [option]| x軸方向に移動する。 |left:左方向,right:右方向|
| wait [option]| [option]までの処理を止めておく。|n:(n \in Z),on grounded:地面につくまで待つ|
|stop|移動や加速を停止する。|-|
|jump|ジャンプする|-|
|hook [option]|[option]方向にフックを伸ばす。|(up,down)+(left,right)|
